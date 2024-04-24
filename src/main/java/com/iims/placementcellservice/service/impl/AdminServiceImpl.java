package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.Admin;
import com.iims.placementcellservice.model.AdminDto;
import com.iims.placementcellservice.entity.LoginDetails;
import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.model.ResetDto;
import com.iims.placementcellservice.model.StudentDto;
import com.iims.placementcellservice.repository.AdminRepo;
import com.iims.placementcellservice.repository.LoginRepo;
import com.iims.placementcellservice.repository.StudentRepo;
import com.iims.placementcellservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl  implements AdminService {

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private LoginRepo loginRepo;
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ObjectMapper mapper;

    public ResponseEntity<LoginDto> createAdminLoginUser(LoginDto loginDto) {

        if(loginRepo.findById(loginDto.getUsername()).isEmpty()) {
            LoginDetails loginDetails = new LoginDetails();
            loginDetails.setUsername(loginDto.getUsername());
            loginDetails.setPassword(loginDto.getPassword());
            loginDetails.setIsAdmin("Y");
            loginDetails.setAccountStatus("Active");
            loginDetails.setPasswordExpirationDate(Date.valueOf(LocalDate.now().plus(180, ChronoUnit.DAYS)));
            loginDetails.setLastPasswordReset(Date.valueOf(LocalDate.now()));
            loginRepo.save(loginDetails);
            return new ResponseEntity<>(loginDto, HttpStatus.OK);
        }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> createAdminProfile(AdminDto adminDto) {
        if(adminRepo.findByUsername(adminDto.getUsername()).isEmpty()) {
            Admin admin = mapper.convertValue(adminDto, Admin.class);
            adminRepo.save(admin);
            return new ResponseEntity<>("Admin profile created successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Admin profile creation failed", HttpStatus.BAD_REQUEST);
    }


    @Override
    public ResponseEntity<String> updateAdminProfile(AdminDto adminDto) {

        Optional<Admin> admin = adminRepo.findByUsername(adminDto.getUsername());
        if(admin.isPresent()) {
            admin.get().setFirstName(adminDto.getFirstName());
            admin.get().setMiddleName(adminDto.getMiddleName());
            admin.get().setLastName(adminDto.getLastName());
            admin.get().setTitle(adminDto.getTitle());
            admin.get().setMobileNumber(adminDto.getMobileNumber());
            admin.get().setEmail(adminDto.getEmail());
            adminRepo.save(admin.get());
            return new ResponseEntity<>("Admin profile updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Admin profile update failed", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<AdminDto> getAdminProfile(String username) {
        Optional<Admin> admin = adminRepo.findByUsername(username);
        if(admin.isPresent()) {
            AdminDto adminDto = mapper.convertValue(admin, AdminDto.class);
            return new ResponseEntity<>(adminDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @Override
    public ResponseEntity<String> resetAdminPassword(ResetDto resetDto) {
        if(adminRepo.findByUsername(resetDto.getUsername()).isPresent() ) {
            if(adminRepo.findByUsername(resetDto.getUsername()).get().getMobileNumber().equals(resetDto.getValidationString())) {
                LoginDetails loginDetails = loginRepo.findById(resetDto.getUsername()).get();
                loginDetails.setPassword(resetDto.getNewPassword());
                loginRepo.save(loginDetails);
                return new ResponseEntity<>("Password reset successfully", HttpStatus.OK);
            }
            return new ResponseEntity<>("Security details do not match", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<StudentDto>> getPlacedStudents() {
        return new ResponseEntity<>(studentRepo.getPlacedStudents().stream()
                .map(student->mapper.convertValue(student,StudentDto.class))
                .collect(Collectors.toList()),HttpStatus.OK);
    }
}
