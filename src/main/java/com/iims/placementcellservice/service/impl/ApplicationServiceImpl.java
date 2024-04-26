package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.Application;
import com.iims.placementcellservice.model.ApplicationDto;
import com.iims.placementcellservice.repository.ApplicationRepo;
import com.iims.placementcellservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ApplicationRepo applicationRepo;

    @Override
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        return new ResponseEntity<>(applicationRepo.findAll().stream()
                .map(application->mapper.convertValue(application, ApplicationDto.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createPlacementApplication(ApplicationDto applicationDto) {

        if(applicationDto!=null) {
            Application application = mapper.convertValue(applicationDto, Application.class);
            applicationRepo.save(application);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }
}
