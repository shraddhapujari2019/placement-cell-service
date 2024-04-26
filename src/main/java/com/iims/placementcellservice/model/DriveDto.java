package com.iims.placementcellservice.model;

import lombok.Data;

@Data
public class DriveDto {

    int driveId;
    int companyId;
    String driveDate;
    String driveLocation;
    String offeredCtc;
    float sscMarks;
    float hscMarks;
    float graduationMarks;
    String isActiveBacklogAllowed;
    int maxActiveBacklogAllowed;
    String isTotalBacklogAllowed;
    int maxTotalBacklogAllowed;
}
