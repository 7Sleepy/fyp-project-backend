package com.fyp.util;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class OCRImpl {
    public String extractTextFromImage(MultipartFile multipartFileImage) {
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");

        try {
            // Convert the MultipartFile to a File
            File tempFile = File.createTempFile("temp", multipartFileImage.getOriginalFilename());
            multipartFileImage.transferTo(tempFile);

            return tesseract.doOCR(tempFile);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
