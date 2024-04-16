package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.entity.Drive;
import com.iims.placementcellservice.model.CompanyDetailsDto;
import com.iims.placementcellservice.model.DriveDto;
import com.iims.placementcellservice.repository.DriveRepo;
import com.iims.placementcellservice.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriveImpl implements DriveService {
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
    public ResponseEntity<String> updateDriveDetails(DriveDto driveDto) {

        Optional<Drive> drive = driveRepo.findByDriveId(driveDto.getDriveId());
        if(drive.isPresent()) {
            drive.get().setCompanyId(driveDto.getCompanyId());
            drive.get().setDriveDate(driveDto.getDriveDate());
            drive.get().setDriveLocation(driveDto.getDriveLocation());
            drive.get().setOfferedCtc(driveDto.getOfferedCtc());
            drive.get().setSscMarks(driveDto.getSscMarks());
            drive.get().setHscMarks(driveDto.getHscMarks());
            drive.get().setGraduationMarks(driveDto.getGraduationMarks());
            drive.get().setActiveBacklogStatus(driveDto.getActiveBacklogStatus());
            drive.get().setMaxActiveBacklogAllowed(driveDto.getMaxActiveBacklogAllowed());
            drive.get().setHistoricalBacklogStatus(driveDto.getHistoricalBacklogStatus());
            drive.get().setMaxHistBacklogAllowed(driveDto.getMaxHistBacklogAllowed());
            driveRepo.save(drive.get());
            return new ResponseEntity<>("Company details updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company details updated failed", HttpStatus.BAD_REQUEST);
    }
    @Override
    public ResponseEntity<List<Drive>> getAllDrives() {
        return new ResponseEntity<>(driveRepo.findAll(), HttpStatus.OK);
    }
}
