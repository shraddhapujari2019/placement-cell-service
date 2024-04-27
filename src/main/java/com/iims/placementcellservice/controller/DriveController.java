package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.entity.Drive;
import com.iims.placementcellservice.model.DriveDto;
import com.iims.placementcellservice.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = {"*"})
@RestController
@RequestMapping("/drive")
public class DriveController {
    @Autowired
    DriveService driveService;

    @PostMapping("/create")
    public ResponseEntity<DriveDto> createDriveDetails(@RequestBody DriveDto driveDto){
        return driveService.createDriveDetails(driveDto);
    }

    @PutMapping("/update-drive")
    public ResponseEntity<String> updateDriveDetails(@RequestBody DriveDto driveDto){
        return driveService.updateDriveDetails(driveDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Drive>> getDriveDetails(){
        return driveService.getAllDrives();
    }
}
