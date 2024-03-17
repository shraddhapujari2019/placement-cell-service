package com.iims.placementcellservice.util;

import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.StudentDto;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    StudentDto toStudentDto(Student student);

}
