package com.iims.placementcellservice.service;

import com.iims.placementcellservice.model.ApplicationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplicationService {
    ResponseEntity<List<ApplicationDto>> getAllApplications();
    ResponseEntity<String> createPlacementApplication(int driveId, String username);

    ResponseEntity<ApplicationDto> getAppliedDrives(long studentId);

}
