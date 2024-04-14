package com.iims.placementcellservice.model;

import lombok.Data;

@Data
public class DriveDto {

    long driveId;
    long companyId;
    String driveDate;
    String driveLocation;
    String offeredCtc;
    long sscMarks;
    long hscMarks;
    long graduationMarks;
    String activeBacklogStatus;
    long maxActiveBacklogAllowed;
    String historicalBacklogStatus;
    long maxHistBacklogAllowed;
}
