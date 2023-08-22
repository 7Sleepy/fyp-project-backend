package com.fyp.controller;

import com.fyp.response.UploadResponse;
import com.fyp.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "http://localhost:3000")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/upload/{studentId}/{enrollmentId}")
    public UploadResponse extractInformation(
            @PathVariable("studentId") Long studentId,
            @PathVariable("enrollmentId") Long enrollmentId,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        UploadResponse response = new UploadResponse();

        // Check if the file is empty
        if (imageFile.isEmpty()) {
            response.setError("Image file is empty.");
            return response;
        }
        // Check the content type
        if (!imageFile.getContentType().startsWith("image/")) {
            response.setError("Uploaded file is not an image.");
            return response;
        }
        // Check the file extension (optional)
        String originalFilename = imageFile.getOriginalFilename();
        assert originalFilename != null;
        if (!originalFilename.matches(".+\\.(jpg|jpeg|png)$")) {
            response.setError("Invalid image file format. Supported formats: jpg, jpeg, png.");
            return response;
        }
        // Check the file size (optional)
        long maxSizeBytes = 10 * 1024 * 1024; // 10 MB (adjust the size as per your requirement)
        if (imageFile.getSize() > maxSizeBytes) {
            response.setError("Image file size exceeds the maximum allowed limit (10MB).");
            return response;
        }
        // Process the image here (OCR, NLP, etc.)
        return uploadService.sendImage(imageFile, studentId, enrollmentId);
    }
}
