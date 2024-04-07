package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<LoginDetails, Integer> {
        }
