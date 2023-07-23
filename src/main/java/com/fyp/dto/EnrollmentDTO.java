package com.fyp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {

    private Long enrollmentId;
    private Long stdnId;
    private Long classId;
    private String attendance_status;

}
