package com.fyp.entity;
import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_account")
public class Account {

    @Id
    @Column(name = "accId")
    private String accId;

    @Column(name = "accUsername")
    private String accUsername;

    @Column(name = "accPassword")
    private String accPassword;

    @Column(name = "accUserType")
    private String accUserType;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "editedAt")
    private Timestamp editedAt;

    @Column(name = "editedBy")
    private String editedBy;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}