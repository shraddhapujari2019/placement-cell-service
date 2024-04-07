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
        LoginDetails loginInfo = null;
        Optional<LoginDetails> userInfo = loginRepo.findById(uid);
        if(userInfo.isPresent()) {
            loginInfo = userInfo.get();
            if (loginInfo.getPassword().equals(password) && loginInfo.getAccount_status().equals("Active")) {
                loginInfo.setLast_login_date(Date.valueOf(LocalDate.now()));
                loginRepo.save(loginInfo);
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
