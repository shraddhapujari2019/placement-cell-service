package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.PlacementStatus;
import com.iims.placementcellservice.model.PlacementStatusDto;
import com.iims.placementcellservice.repository.PlacementRepo;
import com.iims.placementcellservice.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlacementServiceImpl implements PlacementService {

    @Autowired
    PlacementRepo placementRepo;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ResponseEntity<String> createPlacementRecord(PlacementStatusDto placementStatusDto){
        if(placementStatusDto!=null) {
            PlacementStatus placementStatus = mapper.convertValue(placementStatusDto, PlacementStatus.class);
            placementRepo.save(placementStatus);
            return new ResponseEntity<>("Placement record created successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Placement record creation failed", HttpStatus.BAD_REQUEST);

    }

}
