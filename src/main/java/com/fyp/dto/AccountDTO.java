package com.fyp.dto;

import com.fyp.entity.Administrator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long accId;

    private String accUsername;

    private String accPassword;

    private String acc_usertype;

    private Boolean isDeleted;

    // Relationships
    // For administrator
    private Administrator administrator;

    // For lecturer
    private LecturerDTO lecturer;

    // For student
    private StudentDTO student;
}
