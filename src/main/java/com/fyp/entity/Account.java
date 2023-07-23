package com.fyp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_Id")
    private Long accId;

    @Column(name = "acc_username", nullable = false)
    private String accUsername;

    @Column(name = "acc_password", nullable = false)
    private String accPassword;

    @Column(name = "acc_usertype", nullable = false)
    private String acc_usertype;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    // Relationships
    // For administrator
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "adm_id")
    private Administrator administrator;

    // For lecturer
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "lect_id")
    private Lecturer lecturer;

    // For student
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "stdn_id")
    private Student student;
}