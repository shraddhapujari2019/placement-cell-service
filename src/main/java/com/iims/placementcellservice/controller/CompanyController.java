package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.model.CompanyDetailsDto;
import com.iims.placementcellservice.service.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = {"*"})
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyDetailsService companyDetailsService;

    @PostMapping("/create")
    public ResponseEntity<CompanyDetailsDto> createCompanyDetails(@RequestBody CompanyDetailsDto companyDetailsDto) {
        return companyDetailsService.createCompanyDetails(companyDetailsDto);
    }

    @PutMapping("/update-company-details")
    public ResponseEntity<String> updateCompanyDetails(@RequestBody CompanyDetailsDto companyDetailsDto) {
        return companyDetailsService.updateCompanyDetails(companyDetailsDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CompanyDetailsDto>> getCompanyDetails() {
        return companyDetailsService.getAllCompanies();
    }

}