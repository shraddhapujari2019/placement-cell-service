package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.PlacementStatus;
import com.iims.placementcellservice.model.PlacementStatusDto;
import com.iims.placementcellservice.repository.PlacementStatusRepo;
import com.iims.placementcellservice.service.PlacementStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlacementStatusServiceImpl implements PlacementStatusService {

    @Autowired
    private PlacementStatusRepo placementStatusRepo;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public ResponseEntity<PlacementStatusDto> createPlacementRecord(PlacementStatusDto placementStatusDto) {
        if(placementStatusDto!=null){
            PlacementStatus placementStatus = mapper.convertValue(placementStatusDto, PlacementStatus.class);
            placementStatus = placementStatusRepo.save(placementStatus);
            return new ResponseEntity<>(mapper.convertValue(placementStatus, PlacementStatusDto.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
