package com.fyp.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @Column(name = "stdnId")
    private String stdnId;

    @Column(name = "stdnIdNumber")
    private String stdnIdNumber;

    @Column(name = "stdnName")
    private String stdnName;

    @Column(name = "stdnEmail")
    private String stdnEmail;

    @Column(name = "stdnDob")
    private String stdnDob;

    @Column(name = "stdnGender")
    private String stdnGender;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "editedAt")
    private Timestamp editedAt;

    @Column(name = "editedBy")
    private String editedBy;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}