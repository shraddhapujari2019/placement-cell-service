package com.iims.placementcellservice.service;

import com.iims.placementcellservice.model.AdminDto;
import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.model.ResetDto;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    ResponseEntity<LoginDto> createAdminLoginUser(LoginDto loginDto);
    ResponseEntity<String> createAdminProfile(AdminDto admin);
    ResponseEntity<String> resetAdminPassword(ResetDto resetDto);
}
