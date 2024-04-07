package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.StudentVO;
import com.iims.placementcellservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/create-student")
    public void createStudent(@RequestBody StudentVO student){
        studentService.createStudentUser(student);
    }
}
