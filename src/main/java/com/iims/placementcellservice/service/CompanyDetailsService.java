package com.iims.placementcellservice.service;

import com.iims.placementcellservice.model.CompanyDetailsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyDetailsService {
    ResponseEntity<CompanyDetailsDto> createCompanyDetails(CompanyDetailsDto companyDetailsDto);
    ResponseEntity<List<CompanyDetailsDto>> getAllCompanies();
    ResponseEntity<String> updateCompanyDetails(CompanyDetailsDto companyDetailsDto);
}
