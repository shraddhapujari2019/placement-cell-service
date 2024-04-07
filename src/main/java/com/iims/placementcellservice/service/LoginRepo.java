package com.iims.placementcellservice.service;

import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<LoginDetails, Integer> {
        }
