package com.iims.placementcellservice.service.impl;

import com.iims.placementcellservice.model.StudentDto;
import com.iims.placementcellservice.service.StudentRepo;
import com.iims.placementcellservice.service.StudentService;
import com.iims.placementcellservice.util.StudentMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentMapperImpl mapper;

    @Override
    public List<StudentDto> getStudents() {
       return studentRepo.findAll().stream().map(s -> mapper.toStudentDto(s)).collect(Collectors.toList());

    }
}
