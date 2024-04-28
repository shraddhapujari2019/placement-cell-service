package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.CompanyDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetails, Integer> {
}
