package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.entity.LoginDetails;
import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.model.ResetDto;
import com.iims.placementcellservice.model.StudentDto;
import com.iims.placementcellservice.repository.LoginRepo;
import com.iims.placementcellservice.repository.StudentRepo;
import com.iims.placementcellservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    LoginRepo loginRepo;

    @Override
    public ResponseEntity<List<StudentDto>> getStudents() {
       return new ResponseEntity(studentRepo.findAll().stream()
               .map(student->mapper.convertValue(student,StudentDto.class))
               .collect(Collectors.toList()), HttpStatus.OK);

    }

    public ResponseEntity<StudentDto> getStudentProfile(String username){
        Optional<Student> student =  studentRepo.findByUsername(username);

        if(student.isPresent()) {
            StudentDto studentDto = mapper.convertValue(student, StudentDto.class);
            return new ResponseEntity<>(studentDto, HttpStatus.OK);
        }
        //chutya Ajya ... empty user return kar ...
        return new ResponseEntity<>(new StudentDto(),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String> createStudentProfile(StudentDto studentDto) {
        if(studentRepo.findByUsername(studentDto.getUsername()).isEmpty()) {
            Student student = mapper.convertValue(studentDto, Student.class);
            studentRepo.save(student);
            return new ResponseEntity<>("Student profile created successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Student profile creation failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<LoginDto> createStudentLoginUser(LoginDto loginDto) {

        if(loginRepo.findById(loginDto.getUsername()).isEmpty()) {
            LoginDetails loginDetails = new LoginDetails();
            loginDetails.setUsername(loginDto.getUsername());
            loginDetails.setPassword(loginDto.getPassword());
            loginDetails.setIsAdmin("N");
            loginDetails.setAccountStatus("Active");
            loginDetails.setPasswordExpirationDate(Date.valueOf(LocalDate.now().plus(180, ChronoUnit.DAYS)));
            loginDetails.setLastPasswordReset(Date.valueOf(LocalDate.now()));
            loginRepo.save(loginDetails);
            return new ResponseEntity<>(loginDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> resetStudentPassword(ResetDto resetDto) {
        if(studentRepo.findByUsername(resetDto.getUsername()).isPresent() ) {
            SimpleDateFormat df = new SimpleDateFormat("MMdd");
            if(df.format(studentRepo.findByUsername(resetDto.getUsername()).get().getDateOfBirth()).equals(resetDto.getValidationString())) {
                LoginDetails loginDetails = loginRepo.findById(resetDto.getUsername()).get();
                loginDetails.setPassword(resetDto.getNewPassword());
                loginRepo.save(loginDetails);
                return new ResponseEntity<>("Password reset successfully", HttpStatus.OK);
            }
            return new ResponseEntity<>("Security details do not match", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> updateStudentProfile(StudentDto studentDto){
        Optional<Student> student = studentRepo.findByUsername(studentDto.getUsername());
         if(student.isPresent()){
             student.get().setFirstName(studentDto.getFirstName());
             student.get().setMiddleName(studentDto.getMiddleName());
             student.get().setLastName(studentDto.getLastName());
             student.get().setMobileNumber(studentDto.getMobileNumber());
             student.get().setEmail(studentDto.getEmail());
//             student.get().setActiveBacklog(studentDto.getActiveBacklog());
//             student.get().setCurrentAddress(studentDto.getCurrentAddress());
//             student.get().setPermanentAddress(studentDto.getPermanentAddress());
//             student.get().setCompanyName(studentDto.getCompanyName());
//             student.get().setExperience(studentDto.getExperience());
//             student.get().setExperienceStartDate(studentDto.getExperienceStartDate());
//             student.get().setExperienceEndDate(studentDto.getExperienceEndDate());
//             student.get().setTotalBacklog(studentDto.getTotalBacklog());

           studentRepo.save(student.get());
             return new ResponseEntity<>("Student profile updated successfully", HttpStatus.OK);
         }
        return new ResponseEntity<>("Student profile update failed", HttpStatus.BAD_REQUEST);

    }
}
