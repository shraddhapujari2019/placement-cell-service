package com.iims.placementcellservice.service.impl;

import com.iims.placementcellservice.entity.LoginDetails;
import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.repository.LoginRepo;
import com.iims.placementcellservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo loginRepo;

    public ResponseEntity<String> userLogin(LoginDto loginDto){
        LoginDetails loginDetails = null;
        Optional<LoginDetails> userInfo = loginRepo.findById(loginDto.getUsername());
        if(userInfo.isPresent() && userInfo.get().getIsAdmin().equals("N")) {
            loginDetails = userInfo.get();
            if (loginDetails.getPassword().equals(loginDto.getPassword()) && loginDetails.getAccountStatus().equals("Active")) {
                loginDetails.setLastLoginDate(Date.valueOf(LocalDate.now()));
                loginRepo.save(loginDetails);
                return new ResponseEntity<>("Login Successful", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<String> adminLogin(LoginDto loginDto){
        LoginDetails loginDetails = null;
        Optional<LoginDetails> userInfo = loginRepo.findById(loginDto.getUsername());
        if(userInfo.isPresent() && userInfo.get().getIsAdmin().equals("Y")) {
            loginDetails = userInfo.get();
            if (loginDetails.getPassword().equals(loginDto.getPassword()) && loginDetails.getAccountStatus().equals("Active")) {
                loginDetails.setLastLoginDate(Date.valueOf(LocalDate.now()));
                loginRepo.save(loginDetails);
                return new ResponseEntity<>("Login Successful", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
    }


}
