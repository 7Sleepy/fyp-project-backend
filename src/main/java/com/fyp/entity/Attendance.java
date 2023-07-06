package com.fyp.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_attendance")
public class Attendance {

    @Id
    @Column(name = "stdnAttendanceId")
    private String stdnAttendanceId;

    @Column(name = "stdnId")
    private String stdnId;

    @Column(name = "stdnAttPercent")
    private String stdnAttPercent;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "editedAt")
    private Timestamp editedAt;

    @Column(name = "editedBy")
    private String editedBy;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}