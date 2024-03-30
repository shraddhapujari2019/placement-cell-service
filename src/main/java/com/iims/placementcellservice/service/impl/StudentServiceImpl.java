package com.iims.placementcellservice.service.impl;

import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.LoginDetails;
import com.iims.placementcellservice.service.LoginRepo;
import com.iims.placementcellservice.service.LoginService;
import com.iims.placementcellservice.service.StudentRepo;
import com.iims.placementcellservice.service.StudentService;
import com.iims.placementcellservice.util.StudentMapper;
import com.iims.placementcellservice.util.StudentMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    LoginService loginService;

    @Override
    public List<Student> getStudents() {
       return studentRepo.findAll();

    }
    public void createStudentUser(Student student){
        studentRepo.save(student);

        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setLogin_id(student.getId());
        loginDetails.setPassword("");
        loginDetails.set_admin(false);
        loginDetails.setPassword_expiration_date(Date.valueOf(LocalDate.now().plus(180, ChronoUnit.DAYS)));
        loginDetails.setLast_password_reset(Date.valueOf(LocalDate.now()));

        loginService.saveUser(loginDetails);

    }

}
