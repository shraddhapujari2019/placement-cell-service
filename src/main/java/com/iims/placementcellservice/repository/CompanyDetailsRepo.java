package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetails, Integer> {
}
