package com.fyp.response;

import lombok.Data;

@Data
public class UploadResponse {
    private String firstName;
    private String lastName;
    private String studentIDNumber;
    private String attendanceAttempt;
    private String error;
}
