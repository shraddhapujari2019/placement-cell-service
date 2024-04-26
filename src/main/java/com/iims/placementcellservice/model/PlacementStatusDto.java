package com.iims.placementcellservice.model;

import lombok.Data;
@Data
public class PlacementStatusDto {
    long studentId;
    long driveId;
    String offeredCtc;
    String hasAccepted;
    String offerReleaseDate;
    String dateOfJoining;
}