package com.iims.placementcellservice.model;

import lombok.Data;

@Data
public class CompanyDriveDto {
    int driveId;
    String companyName;
    String driveDate;
    String driveLocation;
    String offeredCtc;
}
