package com.iims.placementcellservice.model;

import lombok.Data;

@Data
public class PlacementStatusDto {
    long studentId;
    int driveId;
    String offeredCtc;
    String hasAccepted;
    String offerReleaseDate;
    String dateOfJoining;
}
