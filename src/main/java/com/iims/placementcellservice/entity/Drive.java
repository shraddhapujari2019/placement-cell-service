package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.*;

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
    private String driveDate;
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
    private long maxActiveBacklogAllowed;
    @Column(name = "HISTORICAL_BACKLOG_STATUS")
    private String historicalBacklogStatus;
    @Column(name = "MAX_HIST_BACKLOG_ALLOWED")
    private long maxHistBacklogAllowed;

    public long getDriveId() {
        return driveId;
    }

    public void setDriveId(long driveId) {
        this.driveId = driveId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(String driveDate) {
        this.driveDate = driveDate;
    }

    public String getDriveLocation() {
        return driveLocation;
    }

    public void setDriveLocation(String driveLocation) {
        this.driveLocation = driveLocation;
    }

    public String getOfferedCtc() {
        return offeredCtc;
    }

    public void setOfferedCtc(String offeredCtc) {
        this.offeredCtc = offeredCtc;
    }

    public long getSscMarks() {
        return sscMarks;
    }

    public void setSscMarks(long sscMarks) {
        this.sscMarks = sscMarks;
    }

    public long getHscMarks() {
        return hscMarks;
    }

    public void setHscMarks(long hscMarks) {
        this.hscMarks = hscMarks;
    }

    public long getGraduationMarks() {
        return graduationMarks;
    }

    public void setGraduationMarks(long graduationMarks) {
        this.graduationMarks = graduationMarks;
    }

    public String getActiveBacklogStatus() {
        return activeBacklogStatus;
    }

    public void setActiveBacklogStatus(String activeBacklogStatus) {
        this.activeBacklogStatus = activeBacklogStatus;
    }

    public long getMaxActiveBacklogAllowed() {
        return maxActiveBacklogAllowed;
    }

    public void setMaxActiveBacklogAllowed(long maxActiveBacklogAllowed) {
        this.maxActiveBacklogAllowed = maxActiveBacklogAllowed;
    }

    public String getHistoricalBacklogStatus() {
        return historicalBacklogStatus;
    }

    public void setHistoricalBacklogStatus(String historicalBacklogStatus) {
        this.historicalBacklogStatus = historicalBacklogStatus;
    }

    public long getMaxHistBacklogAllowed() {
        return maxHistBacklogAllowed;
    }

    public void setMaxHistBacklogAllowed(long maxHistBacklogAllowed) {
        this.maxHistBacklogAllowed = maxHistBacklogAllowed;
    }
}
