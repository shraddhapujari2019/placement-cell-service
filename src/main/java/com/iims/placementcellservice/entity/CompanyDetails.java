package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "company_details")
public class CompanyDetails {

    @Id
    @Column(name = "COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long companyId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "ORG_TYPE")
    private String orgType;
    @Column(name = "SECTOR")
    private String sector;
    @Column(name = "COMPANY_WEBSITE")
    private String companyWebsite;
    @Column(name = "COMPANY_INFO")
    private String companyInfo;
    @Column(name = "JOB_LOCATION")
    private String jobLocation;
    @Column(name = "ROLE")
    private String role;

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
