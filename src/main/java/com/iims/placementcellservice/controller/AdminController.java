package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.model.AdminVO;
import com.iims.placementcellservice.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    AdminServiceImpl adminService;
    @GetMapping("/create-admin")
    public void createAdmin(@RequestBody AdminVO admin)
    {
        adminService.createAdminUser(admin);
    }
}
