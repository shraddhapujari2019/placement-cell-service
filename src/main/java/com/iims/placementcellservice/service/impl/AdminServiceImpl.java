package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.Admin;
import com.iims.placementcellservice.model.AdminVO;
import com.iims.placementcellservice.entity.LoginDetails;
import com.iims.placementcellservice.repository.AdminRepo;
import com.iims.placementcellservice.service.AdminService;
import com.iims.placementcellservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AdminServiceImpl  implements AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private LoginService loginService;

    @Autowired
    ObjectMapper mapper;


    public void createAdminUser(AdminVO adminVO) {
        Admin admin = mapper.convertValue(adminVO, Admin.class);
        adminRepo.save(admin);

        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setLogin_id(admin.getAdmin_id());
        loginDetails.setPassword(adminVO.getPassword());
        loginDetails.set_admin(false);
        loginDetails.setPassword_expiration_date(Date.valueOf(LocalDate.now().plus(180, ChronoUnit.DAYS)));
        loginDetails.setLast_password_reset(Date.valueOf(LocalDate.now()));

        loginService.saveUser(loginDetails);

    }
}
