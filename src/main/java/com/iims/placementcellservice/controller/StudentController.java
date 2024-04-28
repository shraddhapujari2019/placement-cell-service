package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.model.*;
import com.iims.placementcellservice.service.ApplicationService;
import com.iims.placementcellservice.service.DriveService;
import com.iims.placementcellservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(originPatterns = {"*"})
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private DriveService driveService;

    @GetMapping ("/list")
    public ResponseEntity<List<StudentDto>> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping ("/student-profile")
    public ResponseEntity<StudentDto> getStudentProfile(@RequestParam String username)
    {
        return studentService.getStudentProfile(username);
    }

    @PostMapping("/create-student")
    public ResponseEntity<LoginDto> createStudent(@RequestBody LoginDto loginDto)
    {
        return studentService.createStudentLoginUser(loginDto);
    }
    @PostMapping ("/create-student-profile")
    public ResponseEntity<String> createStudentProfile(@RequestBody StudentDto studentDto)
    {
        return studentService.createStudentProfile(studentDto);
    }

    @PutMapping ("/update-student-profile")
    public ResponseEntity<String> updateStudentProfile(@RequestBody StudentDto studentDto)
    {
        return studentService.updateStudentProfile(studentDto);
    }

    @PostMapping ("/reset")
    public ResponseEntity<String> resetStudentPassword(@RequestBody ResetDto resetDto)
    {
        return studentService.resetStudentPassword(resetDto);
    }

    @PostMapping("/create-application")
    public ResponseEntity<String> createPlacementApplication(@RequestParam int driveId,  @RequestParam String username, @RequestBody(required = false) ApplicationDto applicationDto)
    {
        return applicationService.createPlacementApplication(driveId, username);
    }

    @GetMapping("/get-applications")
    public ResponseEntity<ApplicationDto> getAppliedDrives(@RequestParam long studentId)
    {
        return applicationService.getAppliedDrives(studentId);
        //return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-drives")
    public ResponseEntity<List<CompanyDriveDto>> getAllDrives(@RequestParam String username)
    {
        return driveService.getAllDrives(username);
    }
}
