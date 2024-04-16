package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.Drive;
import com.iims.placementcellservice.model.DriveDto;
import com.iims.placementcellservice.repository.DriveRepo;
import com.iims.placementcellservice.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveServiceImpl implements DriveService {
    @Autowired
    DriveRepo driveRepo;

    @Autowired
    ObjectMapper driveMapper;

    @Override
    public ResponseEntity<DriveDto> createDriveDetails(DriveDto driveDto) {
        if(driveDto == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        Drive drive = driveMapper.convertValue(driveDto, Drive.class);
        Drive driveDbRecord = driveRepo.save(drive);

        return new ResponseEntity<>(driveMapper.convertValue(driveDbRecord,DriveDto.class), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<Drive>> getAllDrives() {
        return new ResponseEntity<>(driveRepo.findAll(), HttpStatus.OK);
    }
}
