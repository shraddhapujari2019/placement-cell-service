package com.iims.placementcellservice.model;

import lombok.Data;

@Data
public class CompanyDetailsDto {
    int companyId;
    String companyName;
    String orgType;
    String sector;
    String companyWebsite;
    String companyInfo;
    String jobLocation;
    String role;
}
