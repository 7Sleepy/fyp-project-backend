package com.fyp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {

    private Long classId;

    @NotEmpty(message = "Please do not leave the class name field empty.")
    private String class_name;

    @NotEmpty(message = "Please do not leave the class date field empty.")
    private String class_date;

    @NotEmpty(message = "Please do not leave the class start time field empty.")
    private String class_start_time;

    @NotEmpty(message = "Please do not leave the class end time field empty.")
    private String class_end_time;

    @NotEmpty(message = "Please do not leave the class status field empty.")
    private String class_status;

    private Boolean isDeleted;

    private Long lecturerId;

    private List<Long> enrolledStdnId;
}
