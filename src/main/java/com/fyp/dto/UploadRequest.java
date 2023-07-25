package com.fyp.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadRequest {
    private Long id;
    private MultipartFile imageFile;
}
