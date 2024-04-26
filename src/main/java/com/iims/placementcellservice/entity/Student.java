package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "student_info")
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLL_NUMBER", nullable = false)
    private String rollNumber;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    private Timestamp dateOfBirth;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "MOBILE_NUMBER", nullable = false)
    private String mobileNumber;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "CURRENT_ADDRESS")
    private String currentAddress;

    @Column(name = "PERMANENT_ADDRESS")
    private String permanentAddress;

    @Column(name = "COURSE")
    private String course;

    @Column(name = "ADMISSION_YEAR")
    private String admissionYear;

    @Column(name = "PASSING_YEAR")
    private String passingYear;

    @Column(name = "SEMESTER")
    private String semester;

    @Column(name = "DIVISION")
    private String division;

    @Column(name = "COLLEGE_NAME")
    private String collegeName;

    @Column(name = "SSC_PASSING_YEAR")
    private String sscPassingYear;

    @Column(name = "SSC_MARKS")
    private String sscMarks;

    @Column(name = "HSC_PASSING_YEAR")
    private String hscPassingYear;

    @Column(name = "HSC_MARKS")
    private String hscMarks;

    @Column(name = "HIGHEST_QUALIFICATION_NAME")
    private String highestQualificationName;

    @Column(name = "HIGHEST_QUALIFICATION_PASSING_YEAR")
    private String highestQualificationPassingYear;

    @Column(name = "HIGHEST_QUALIFICATION_MARKS")
    private String highestQualificationMarks;

    @Column(name = "OTHER_GRADUATION_NAME")
    private String otherGraduationName;

    @Column(name = "OTHER_GRADUATION_PASSING_YEAR")
    private String otherGraduationPassingYear;

    @Column(name = "OTHER_GRADUATION_MARKS")
    private String otherGraduationMarks;

    @Column(name = "GAP")
    private String gap;

    @Column(name = "GAP_START_DATE")
    private Timestamp gapStartDate;

    @Column(name = "GAP_END_DATE")
    private Timestamp gapEndDate;

    @Column(name = "SEM_1_MARKS")
    private Integer sem1Marks;

    @Column(name = "SEM_2_MARKS")
    private Integer sem2Marks;

    @Column(name = "SEM_3_MARKS")
    private Integer sem3Marks;

    @Column(name = "SEM_4_MARKS")
    private Integer sem4Marks;

    @Column(name = "ACTIVE_BACKLOG")
    private Integer activeBacklog;

    @Column(name = "TOTAL_BACKLOGS")
    private Integer totalBacklog;

    @Column(name = "EXPERIENCE")
    private String experience;

    @Column(name = "EXPERIENCE_START_DATE")
    private Timestamp experienceStartDate;

    @Column(name = "EXPERIENCE_END_DATE")
    private Timestamp experienceEndDate;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "USER_NAME")
    private String userName;

}
