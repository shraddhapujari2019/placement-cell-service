package com.iims.placementcellservice.service;

import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.StudentVO;

import java.util.List;

public interface StudentService {

    public List<Student> getStudents();

    void createStudentUser(StudentVO student);
}
