package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.entity.Student;
import com.iims.placementcellservice.model.CompanyDetailsDto;
import com.iims.placementcellservice.model.LoginDto;
import com.iims.placementcellservice.repository.CompanyDetailsRepo;
import com.iims.placementcellservice.service.CompanyDetailsService;
import com.iims.placementcellservice.util.CompanyDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService {
    @Autowired
    CompanyDetailsRepo companyDetailsRepo;
    @Autowired
    ObjectMapper companyDetailsMapper;
    @Override
    public ResponseEntity<CompanyDetailsDto> createCompanyDetails(CompanyDetailsDto companyDetailsDto) {
        if(companyDetailsDto == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        CompanyDetails companyDetails = companyDetailsMapper.convertValue(companyDetailsDto, CompanyDetails.class);
        CompanyDetails companyDetailsDbRecord = companyDetailsRepo.save(companyDetails);

        return new ResponseEntity<>(companyDetailsMapper.convertValue(companyDetailsDbRecord,CompanyDetailsDto.class), HttpStatus.OK);

    }
}
