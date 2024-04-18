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
    private long driveId;
    @Column(name = "COMPANY_ID")
    private long companyId;
    @Column(name = "DRIVE_DATE")
    private Date driveDate;
    @Column(name = "DRIVE_LOCATION")
    private String driveLocation;
    @Column(name = "OFFERED_CTC")
    private String offeredCtc;
    @Column(name = "SSC_MARKS")
    private long sscMarks;
    @Column(name = "HSC_MARKS")
    private long hscMarks;
    @Column(name = "GRADUATION_MARKS")
    private long graduationMarks;
    @Column(name = "ACTIVE_BACKLOG_STATUS")
    private String activeBacklogStatus;
    @Column(name = "MAX_ACTIVE_BACKLOG_ALLOWED")
    private long maxActiveBacklogStatus;
    @Column(name = "HISTORICAL_BACKLOG_STATUS")
    private String historicalBacklogStatus;
    @Column(name = "MAX_HIST_BACKLOG_ALLOWED")
    private long maxHistBacklogAllowed;
}
