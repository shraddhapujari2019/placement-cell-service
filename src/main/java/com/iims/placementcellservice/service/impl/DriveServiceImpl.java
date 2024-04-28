package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.Drive;
import com.iims.placementcellservice.model.CompanyDriveDto;
import com.iims.placementcellservice.model.DriveDto;
import com.iims.placementcellservice.repository.DriveRepo;
import com.iims.placementcellservice.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriveServiceImpl implements DriveService {
    @Autowired
    DriveRepo driveRepo;

    @Autowired
    ObjectMapper driveMapper;

    @Override
    public ResponseEntity<DriveDto> createDriveDetails(DriveDto driveDto) {
        if(driveDto!=null){
            Drive drive = driveMapper.convertValue(driveDto, Drive.class);
            drive = driveRepo.save(drive);
            return new ResponseEntity<>(driveMapper.convertValue(drive, DriveDto.class), HttpStatus.OK);
        }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Drive>> getAllDrives() {
        return new ResponseEntity<>(driveRepo.findAll(), HttpStatus.OK);
    }

    @Override
    @PutMapping("/update-drive")
    public ResponseEntity<String> updateDriveDetails(DriveDto driveDto) {
        Optional<Drive> driveDetails = driveRepo.findById(driveDto.getDriveId());
        if(driveDetails.isPresent()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            driveDetails.get().setCompanyId(driveDto.getCompanyId());
            try {
                driveDetails.get().setDriveDate(sdf.parse(driveDto.getDriveDate()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            driveDetails.get().setDriveLocation(driveDto.getDriveLocation());
            driveDetails.get().setGraduationMarks(driveDto.getGraduationMarks());
            driveDetails.get().setHscMarks(driveDto.getHscMarks());
            driveDetails.get().setIsActiveBacklogAllowed(driveDto.getIsActiveBacklogAllowed());
            driveDetails.get().setMaxActiveBacklogAllowed(driveDto.getMaxActiveBacklogAllowed());
            driveDetails.get().setIsTotalBacklogAllowed(driveDto.getIsTotalBacklogAllowed());
            driveDetails.get().setMaxTotalBacklogAllowed(driveDto.getMaxTotalBacklogAllowed());
            driveDetails.get().setOfferedCtc(driveDto.getOfferedCtc());
            driveDetails.get().setSscMarks(driveDto.getSscMarks());
            driveRepo.save(driveDetails.get());
            return new ResponseEntity<>("Drive details updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Drive details update failed",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<CompanyDriveDto>> getAllDrives(String username) {
        return new ResponseEntity<>(driveRepo.getAllDrives(username).stream().map(drive->driveMapper.convertValue(drive,CompanyDriveDto.class)).collect(Collectors.toList()),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CompanyDriveDto>> getAllDrivesWithCompany() {
        return new ResponseEntity<>(driveRepo.getAllDrivesWithCompany().stream().map(drive->driveMapper.convertValue(drive,CompanyDriveDto.class)).collect(Collectors.toList()),HttpStatus.OK);
    }
}
