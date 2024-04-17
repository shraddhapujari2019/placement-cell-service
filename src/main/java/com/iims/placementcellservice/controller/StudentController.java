package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.model.ResetDto;
import com.iims.placementcellservice.model.StudentDto;
import com.iims.placementcellservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
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
}
