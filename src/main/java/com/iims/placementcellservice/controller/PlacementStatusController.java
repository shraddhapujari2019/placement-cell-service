package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.model.PlacementStatusDto;
import com.iims.placementcellservice.service.impl.PlacementStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = {"*"})
@RestController
@RequestMapping("/placement-status")
public class PlacementStatusController {

    @Autowired
    PlacementStatusServiceImpl placementService;
    @PostMapping("/create")
    public ResponseEntity<PlacementStatusDto> createPlacementRecord(@RequestBody PlacementStatusDto placementStatusDto)
    {
        return placementService.createPlacementRecord(placementStatusDto);
    }
}
