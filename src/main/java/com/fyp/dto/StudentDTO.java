package com.fyp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long stdnId;
    private String stdn_id_number;
    private String stdn_firstname;
    private String stdn_lastname;
    private String stdn_email;
    private String stdn_dob;
    private String stdn_gender;
    private Boolean isDeleted;

    // For Enrollment
    private List<EnrollmentDTO> enrollmentList = new ArrayList<>();
}
