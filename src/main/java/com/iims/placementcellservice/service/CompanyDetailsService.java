package com.iims.placementcellservice.service;

import com.iims.placementcellservice.model.CompanyDetailsDto;
import com.iims.placementcellservice.model.LoginDto;
import org.springframework.http.ResponseEntity;

public interface CompanyDetailsService {
    ResponseEntity<CompanyDetailsDto> createCompanyDetails(CompanyDetailsDto companyDetailsDto);
}
