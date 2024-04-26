package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class PlacementStatus {
    @Id
    long studentId;
    int driveId;
    String offeredCtc;
    String hasAccepted;
    Date offerReleaseDate;
    Date dateOfJoining;

}
