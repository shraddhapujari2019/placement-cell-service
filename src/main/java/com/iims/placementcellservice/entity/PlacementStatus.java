package com.iims.placementcellservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "placement_status")
public class PlacementStatus {

    @Id
    @Column(name = "STUDENT_ID")
    long studentId;

    @Column(name = "DRIVE_ID")
    long driveId;

    @Column(name = "OFFERED_CTC")
    String offeredCtc;

    @Column(name = "HAS_ACCEPTED")
    String hasAccepted;

    @Column(name = "OFFER_RELEASE_DATE")
    String offerReleaseDate;

    @Column(name = "DATE_OF_JOINING")
    String dateOfJoining;
}
