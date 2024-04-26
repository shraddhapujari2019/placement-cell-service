package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "drive_details")
public class Drive {

    @Id
    @Column(name = "DRIVE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driveId;
    @Column(name = "COMPANY_ID")
    private int companyId;
    @Column(name = "DRIVE_DATE")
    private Date driveDate;
    @Column(name = "DRIVE_LOCATION")
    private String driveLocation;
    @Column(name = "OFFERED_CTC")
    private String offeredCtc;
    @Column(name = "SSC_MARKS")
    private float sscMarks;
    @Column(name = "HSC_MARKS")
    private float hscMarks;
    @Column(name = "GRADUATION_MARKS")
    private float graduationMarks;
    @Column(name = "IS_ACTIVE_BACKLOG_ALLOWED")
    private String isActiveBacklogAllowed;
    @Column(name = "MAX_ACTIVE_BACKLOG_ALLOWED")
    private int maxActiveBacklogAllowed;
    @Column(name = "IS_TOTAL_BACKLOG_ALLOWED")
    private String isTotalBacklogAllowed;
    @Column(name = "MAX_TOTAL_BACKLOG_ALLOWED")
    private int maxTotalBacklogAllowed;
}
