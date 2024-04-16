package com.iims.placementcellservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.model.CompanyDetailsDto;
import com.iims.placementcellservice.repository.CompanyDetailsRepo;
import com.iims.placementcellservice.service.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity<String> updateCompanyProfile(CompanyDetailsDto companyDetailsDto) {

        Optional<CompanyDetails> companyDetails = companyDetailsRepo.findByCompanyId(companyDetailsDto.getCompanyId());
        if(companyDetails.isPresent()) {
            companyDetails.get().setCompanyName(companyDetailsDto.getCompanyName());
            companyDetails.get().setRole(companyDetailsDto.getRole());
            companyDetails.get().setCompanyInfo(companyDetailsDto.getCompanyInfo());
            companyDetails.get().setCompanyWebsite(companyDetailsDto.getCompanyWebsite());
            companyDetails.get().setSector(companyDetailsDto.getSector());
            companyDetails.get().setJobLocation(companyDetailsDto.getJobLocation());
            companyDetails.get().setOrgType(companyDetailsDto.getOrgType());
            companyDetailsRepo.save(companyDetails.get());
            return new ResponseEntity<>("Company details updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company details update failed", HttpStatus.BAD_REQUEST);
    }
    @Override
    public ResponseEntity<List<CompanyDetails>> getAllCompanies() {
        return new ResponseEntity<>(companyDetailsRepo.findAll(),HttpStatus.OK);
    }

}
