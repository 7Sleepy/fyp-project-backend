package com.fyp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerDTO {

    private Long lectId;

    @NotEmpty(message = "Please do not leave the lecturer ID Number field empty.")
    private String lect_id_number;

    @NotEmpty(message = "Please do not leave the first name field empty.")
    private String lect_firstname;

    @NotEmpty(message = "Please do not leave the last name field empty.")
    private String lect_lastname;

    @NotEmpty(message = "Please do not leave the email field empty.")
    private String lect_email;

    @NotEmpty(message = "Please do not leave the date of birth field empty.")
    private String lect_dob;

    @NotEmpty(message = "Please do not leave the gender field empty.")
    private String lect_gender;

    private Boolean isDeleted;

    // Additional fields
    private List<ClassDTO> classDTOList = new ArrayList<>();
}
