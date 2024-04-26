package com.iims.placementcellservice.service;


import com.iims.placementcellservice.model.PlacementStatusDto;
import org.springframework.http.ResponseEntity;

public interface PlacementStatusService {
    ResponseEntity<PlacementStatusDto> createPlacementRecord(PlacementStatusDto placementStatusDto);
}
