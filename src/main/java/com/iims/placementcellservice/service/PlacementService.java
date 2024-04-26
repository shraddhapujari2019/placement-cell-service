package com.iims.placementcellservice.service;

import com.iims.placementcellservice.model.PlacementStatusDto;
import org.springframework.http.ResponseEntity;


public interface PlacementService {
    ResponseEntity<String> createPlacementRecord(PlacementStatusDto placementStatusDto);

}
