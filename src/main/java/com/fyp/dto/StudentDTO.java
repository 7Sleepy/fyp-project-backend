package com.fyp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String stdnId;

    private String stdnIdNumber;

    private String stdnName;

    private String stdnEmail;

    private String stdnDob;

    private String stdnGender;

    private Timestamp createdAt;

    private Timestamp editedAt;

    private String editedBy;

    private Boolean isDeleted;
}
