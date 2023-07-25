package com.fyp.entity;

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
@Table(name = "tbl_class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "class_name", nullable = false)
    private String class_name;

    @Column(name = "class_date")
    private String class_date;

    @Column(name = "class_start_time", nullable = false)
    private String class_start_time;

    @Column(name = "class_end_time", nullable = false)
    private String class_end_time;

    @Column(name = "class_status", nullable = false)
    private String class_status;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    // Additional fields

    // For Lecturer
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lect_id")
    private Lecturer lecturer;

    // For Enrollment -> Student
    @OneToMany(mappedBy = "classes")
    private List<Enrollment> enrollmentList = new ArrayList<>();
}
