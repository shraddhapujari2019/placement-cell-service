package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.model.AdminDto;
import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.model.ResetDto;
import com.iims.placementcellservice.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;
    @PostMapping ("/create-admin")
    public ResponseEntity<LoginDto> createAdmin(@RequestBody LoginDto loginDto)
    {
        return adminService.createAdminLoginUser(loginDto);
    }

    @GetMapping ("/admin-profile")
    public ResponseEntity<AdminDto> createAdminProfile(@RequestParam String username)
    {
        return adminService.getAdminProfile(username);
    }
    @PostMapping ("/create-admin-profile")
    public ResponseEntity<String> createAdminProfile(@RequestBody AdminDto adminDto)
    {
        return adminService.createAdminProfile(adminDto);
    }

    @PutMapping ("/update-admin-profile")
    public ResponseEntity<String> updateAdminProfile(@RequestBody AdminDto adminDto)
    {
        return adminService.updateAdminProfile(adminDto);
    }
    @PostMapping ("/reset")
    public ResponseEntity<String> resetAdminPassword(@RequestBody ResetDto resetDto)
    {
        return adminService.resetAdminPassword(resetDto);
    }
}
