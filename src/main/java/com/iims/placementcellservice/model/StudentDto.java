package com.iims.placementcellservice.model;

import lombok.Data;

import java.sql.Date;

@Data
public class StudentDto {

    private int id;

    private String rollNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private Date dateOfBirth;

    private String gender;

    private String mobileNumber;

    private String email;

    private String currentAddress;

    private String permanentAddress;

    private String course;

    private String admissionYear;

    private String passingYear;

    private int semester;

    private String division;

    private String collegeName;

    private String sscPassingYear;

    private float sscMarks;

    private String hscPassingYear;

    private float hscMarks;

    private String highestQualificationName;

    private String highestQualificationPassingYear;

    private float highestQualificationMarks;

    private String otherGraduationName;

    private String otherGraduationPassingYear;

    private float otherGraduationMarks;

    private String gap;

    private Date gapStartDate;

    private Date gapEndDate;

    private float sem1Sgpa;

    private float sem2Sgpa;

    private float sem3Sgpa;

    private float sem4Sgpa;

    private float aggCgpa;

    private Integer activeBacklog;

    private Integer totalBacklog;

    private String experience;

    private Date experienceStartDate;

    private Date experienceEndDate;

    private String companyName;

    private String position;

    private String role;

    private String username;

}
