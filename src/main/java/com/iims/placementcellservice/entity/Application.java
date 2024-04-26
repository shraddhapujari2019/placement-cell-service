package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "APPLICATION_STATUS")
public class Application {
    @Id
    @Column(name = "APPLICATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long applicationId;
    @Column(name = "DRIVE_ID")
    int driveId;
    @Column(name = "STUDENT_ID")
    long studentId;
}
