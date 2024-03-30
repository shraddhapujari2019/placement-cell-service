package com.iims.placementcellservice.service;

import com.iims.placementcellservice.model.Admin;
import com.iims.placementcellservice.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
