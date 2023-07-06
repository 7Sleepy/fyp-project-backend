package com.fyp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String accId;

    @NotEmpty(message = "Please do not leave the username field empty.")
    private String accUsername;

    private String accPassword;

    private String accUserType;

    private Timestamp createdAt;

    private Timestamp editedAt;

    private String editedBy;

    private Boolean isDeleted;
}
