package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.model.*;
import com.iims.placementcellservice.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<AdminDto> getAdminProfile(@RequestParam String userName)
    {
        return adminService.getAdminProfile(userName);
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

//    @PostMapping("/create-placement-record")
//    ResponseEntity<String> createPlacementRecord(@RequestBody PlacementStatusDto placementStatusDto){
//        return placementService.createPlacementRecord(placementStatusDto);
//    }

    @GetMapping("/placed-students")
    public ResponseEntity<List<StudentDto>> getPlacedStudents(){
        return adminService.getPlacedStudents();
    }

}
