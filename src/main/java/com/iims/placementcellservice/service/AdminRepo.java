package com.iims.placementcellservice.service;

import com.iims.placementcellservice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
