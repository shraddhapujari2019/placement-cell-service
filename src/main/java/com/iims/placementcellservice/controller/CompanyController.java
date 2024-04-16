package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.model.CompanyDetailsDto;
import com.iims.placementcellservice.service.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyDetailsService companyDetailsService;

    @PostMapping("/create")
    public ResponseEntity<CompanyDetailsDto> createCompanyDetails(@RequestBody CompanyDetailsDto companyDetailsDto){
       return companyDetailsService.createCompanyDetails(companyDetailsDto);
    }

    @PutMapping ("/update")
    public ResponseEntity<String> updateCompanyProfile(@RequestBody CompanyDetailsDto companyDetailsDto)
    {
        return companyDetailsService.updateCompanyProfile(companyDetailsDto);
    }
    @GetMapping
    public ResponseEntity<List<CompanyDetails>> getCompanyDetails(){
        return companyDetailsService.getAllCompanies();
    }
}
