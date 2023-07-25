package com.fyp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_lecturer")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lect_id")
    private Long lectId;

    @Column(name = "lect_id_number", nullable = false)
    private String lect_id_number;

    @Column(name = "lect_firstname", nullable = false)
    private String lect_firstname;

    @Column(name = "lect_lastname", nullable = false)
    private String lect_lastname;

    @Column(name = "lect_email", nullable = false)
    private String lect_email;

    @Column(name = "lect_dob", nullable = false)
    private String lect_dob;

    @Column(name = "lect_gender", nullable = false)
    private String lect_gender;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    // Additional fields

    // For Account
    @OneToOne(mappedBy = "lecturer")
    @JsonIgnore
    private Account account;

    // For Classes
    @OneToMany(mappedBy = "lecturer", fetch = FetchType.EAGER)
    private List<Class> classList = new ArrayList<>();
}