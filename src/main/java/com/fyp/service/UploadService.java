package com.fyp.service;

import com.fyp.response.UploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    UploadResponse sendImage(MultipartFile image, Long studentId, Long enrollmentId);
}
