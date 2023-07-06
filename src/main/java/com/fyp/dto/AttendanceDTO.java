package com.fyp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDTO {

    private String stdnAttendanceId;

    private String stdnId;

    private String stdnAttPercent;

    private Timestamp createdAt;

    private Timestamp editedAt;

    private String editedBy;

    private Boolean isDeleted;
}
