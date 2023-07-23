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
@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stdn_id")
    private Long stdnId;

    @Column(name = "stdn_id_number", nullable = false)
    private String stdn_id_number;

    @Column(name = "stdn_firstname", nullable = false)
    private String stdn_firstname;

    @Column(name = "stdn_lastname", nullable = false)
    private String stdn_lastname;

    @Column(name = "stdn_email", nullable = false)
    private String stdn_email;

    @Column(name = "stdn_dob", nullable = false)
    private String stdn_dob;

    @Column(name = "stdn_gender", nullable = false)
    private String stdn_gender;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    // Relationships
    // For account
    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private Account account;

    // For Enrollment
    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollmentList = new ArrayList<>();
}