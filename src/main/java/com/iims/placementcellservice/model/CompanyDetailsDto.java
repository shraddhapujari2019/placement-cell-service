package com.iims.placementcellservice.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CompanyDetailsDto {
    long companyId;
    String companyName;
    String orgType;
    String sector;
    String companyWebsite;
    String companyInfo;
    String jobLocation;
    String role;
}
