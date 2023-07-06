package com.fyp.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_lecturer")
public class Lecturer {

    @Id
    @Column(name = "lectId")
    private String lectId;

    @Column(name = "lectIdNo")
    private String lectIdNo;

    @Column(name = "lectName")
    private String lectName;

    @Column(name = "lectEmail")
    private String lectEmail;

    @Column(name = "lectDob")
    private String lectDob;

    @Column(name = "lectGender")
    private String lectGender;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "editedAt")
    private Timestamp editedAt;

    @Column(name = "editedBy")
    private String editedBy;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}