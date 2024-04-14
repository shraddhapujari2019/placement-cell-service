package com.iims.placementcellservice.service;

import com.iims.placementcellservice.entity.Drive;
import com.iims.placementcellservice.model.DriveDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DriveService {
    ResponseEntity<DriveDto> createDriveDetails(DriveDto driveDto);
    ResponseEntity<List<Drive>> getAllDrives();
}
