package com.iims.placementcellservice.controller;

import com.iims.placementcellservice.model.CompanyDetailsDto;
import com.iims.placementcellservice.service.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyDetailsService companyDetailsService;

    @PostMapping("/create")
    public ResponseEntity<CompanyDetailsDto> createCompanyDetails(@RequestBody CompanyDetailsDto companyDetailsDto){
       return companyDetailsService.createCompanyDetails(companyDetailsDto);
    }
}
