package com.fyp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {

    private String classId;

    private String className;

    private String classStatus;

    private Timestamp createdAt;

    private Timestamp editedAt;

    private String editedBy;

    private Boolean isDeleted;
}
