package com.fyp.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_administrator")
public class Administrator {

    @Id
    @Column(name = "admId")
    private String admId;

    @Column(name = "admIdNo")
    private String admIdNo;

    @Column(name = "admName")
    private String admName;

    @Column(name = "admEmail")
    private String admEmail;

    @Column(name = "admDob")
    private String admDob;

    @Column(name = "admGender")
    private String admGender;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "editedAt")
    private Timestamp editedAt;

    @Column(name = "editedBy")
    private String editedBy;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}
