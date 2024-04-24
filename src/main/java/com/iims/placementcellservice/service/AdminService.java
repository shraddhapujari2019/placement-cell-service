package com.iims.placementcellservice.service;

import com.iims.placementcellservice.model.AdminDto;
import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.model.ResetDto;
import com.iims.placementcellservice.model.StudentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    ResponseEntity<LoginDto> createAdminLoginUser(LoginDto loginDto);
    ResponseEntity<String> createAdminProfile(AdminDto admin);

    ResponseEntity<String> updateAdminProfile(AdminDto admin);

    ResponseEntity<AdminDto> getAdminProfile(String username);
    ResponseEntity<String> resetAdminPassword(ResetDto resetDto);

    ResponseEntity<List<StudentDto>> getPlacedStudents();
}
