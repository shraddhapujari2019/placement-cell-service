package com.iims.placementcellservice.service;

import com.iims.placementcellservice.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudents();

    void createStudentUser(Student student);
}
