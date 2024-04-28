package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.Application;
import com.iims.placementcellservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
    Optional<Application> findByStudentId(String studentId);
}
