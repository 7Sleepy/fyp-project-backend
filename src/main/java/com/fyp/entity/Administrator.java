package com.fyp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adm_id")
    private Long admId;

    @Column(name = "adm_id_number", nullable = false)
    private String adm_id_number;

    @Column(name = "adm_firstname", nullable = false)
    private String adm_firstname;

    @Column(name = "adm_lastname", nullable = false)
    private String adm_lastname;

    @Column(name = "adm_email", nullable = false)
    private String adm_email;

    @Column(name = "adm_dob", nullable = false)
    private String adm_dob;

    @Column(name = "adm_gender", nullable = false)
    private String adm_gender;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    // Additional fields
    // For account
    @OneToOne(mappedBy = "administrator")
    @JsonIgnore
    private Account account;
}
