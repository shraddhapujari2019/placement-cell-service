package com.iims.placementcellservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonInclude
public class StudentVO {

    private Long id;

    private String rollNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private Timestamp dateOfBirth;

    private String gender;

    private String mobileNumber;

    private String email;

    
    private String currentAddress;

    
    private String permanentAddress;

    
    private String course;

    
    private String admissionYear;

    
    private String passingYear;

    
    private String semester;

    
    private String division;

    
    private String collegeName;

    
    private String sscPassingYear;

    
    private String sscMarks;

    
    private String hscPassingYear;

    
    private String hscMarks;

    
    private String highestQualificationName;

    
    private String highestQualificationPassingYear;

    
    private String highestQualificationMarks;

    
    private String otherGraduationName;

    
    private String otherGraduationPassingYear;

    
    private String otherGraduationMarks;

    
    private String gap;

    
    private Timestamp gapStartDate;

    
    private Timestamp gapEndDate;

    
    private Integer sem1Marks;

    
    private Integer sem2Marks;

    
    private Integer sem3Marks;

    
    private Integer sem4Marks;

    
    private Integer activeBacklog;

    
    private Integer totalBacklog;

    
    private String experience;

    
    private Timestamp experienceStartDate;

    
    private Timestamp experienceEndDate;

    
    private String companyName;

    
    private String position;

    private String role;

    @JsonIgnore
    private String password;
}
