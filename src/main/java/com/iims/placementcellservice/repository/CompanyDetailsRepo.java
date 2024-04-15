package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.Admin;
import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetails, Long> {
    Optional<CompanyDetails> findByCompanyId(Long companyId);
}
