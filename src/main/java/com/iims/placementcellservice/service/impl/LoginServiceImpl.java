package com.iims.placementcellservice.service.impl;

import com.iims.placementcellservice.model.LoginDetails;
import com.iims.placementcellservice.service.LoginRepo;
import com.iims.placementcellservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo loginRepo;

    public boolean validateLogin(int uid, String password){
        LoginDetails loginDetails = null;
        Optional<LoginDetails> userInfo = loginRepo.findById(uid);
        if(userInfo.isPresent()) {
            loginDetails = userInfo.get();
            if (loginDetails.getPassword().equals(password) && loginDetails.getAccount_status().equals("Active")) {
                loginDetails.setLast_login_date(Date.valueOf(LocalDate.now()));
                loginRepo.save(loginDetails);
                return true;
            }
        }
        return false;
    }
    @Override
    public void saveUser(LoginDetails loginDetails){
        loginRepo.save(loginDetails);
    }

}
