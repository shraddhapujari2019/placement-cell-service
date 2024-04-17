package com.iims.placementcellservice.service;

import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.model.ResetDto;
import com.iims.placementcellservice.model.StudentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<List<StudentDto>> getStudents();

    ResponseEntity<String> createStudentProfile(StudentDto student);
    ResponseEntity<LoginDto> createStudentLoginUser(LoginDto loginDto);

    ResponseEntity<String> resetStudentPassword(ResetDto resetDto);

    ResponseEntity<String> updateStudentProfile(StudentDto studentDto);

    ResponseEntity<StudentDto> getStudentProfile(String username);
}
