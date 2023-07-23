package com.fyp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @Column(name = "attendance_status", nullable = false)
    private String attendance_status;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    // Relationships (not fields)
    // For Students
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stdn_id")
    private Student student;

    // For Class
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Class classes;
}
