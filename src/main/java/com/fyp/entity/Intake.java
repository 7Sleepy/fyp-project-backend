package com.fyp.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_intake")
public class Intake {

    @Id
    @Column(name = "intakeId")
    private String intakeId;

    @Column(name = "intakeName")
    private String intakeName;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "editedAt")
    private Timestamp editedAt;

    @Column(name = "editedBy")
    private String editedBy;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}
