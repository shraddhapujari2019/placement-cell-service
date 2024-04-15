package com.iims.placementcellservice.service;

import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.model.AdminDto;
import com.iims.placementcellservice.model.CompanyDetailsDto;
import com.iims.placementcellservice.model.LoginDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyDetailsService {
    ResponseEntity<CompanyDetailsDto> createCompanyDetails(CompanyDetailsDto companyDetailsDto);
    ResponseEntity<List<CompanyDetails>> getAllCompanies();

    ResponseEntity<String> updateCompanyProfile(CompanyDetailsDto companyDetailsDto);
}
