package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.Application;
import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.ApplicationDto;
import com.iims.placementcellservice.model.StudentDto;
import com.iims.placementcellservice.repository.ApplicationRepo;
import com.iims.placementcellservice.repository.StudentRepo;
import com.iims.placementcellservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        return new ResponseEntity<>(applicationRepo.findAll().stream()
                .map(application->mapper.convertValue(application, ApplicationDto.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createPlacementApplication(int driveId, String username) {

        Optional<Student> student = studentRepo.findByUsername(username);
        if(student.isPresent()) {
            Application application = new Application();
            application.setDriveId(driveId);
            application.setStudentId(student.get().getId());
            applicationRepo.save(application);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<ApplicationDto> getAppliedDrives(long studentId){
        Optional<Application> application =  applicationRepo.findByStudentId(String.valueOf(studentId));
        if(application.isPresent()) {
            ApplicationDto applicationDto = mapper.convertValue(application, ApplicationDto.class);
            return new ResponseEntity<>(applicationDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
