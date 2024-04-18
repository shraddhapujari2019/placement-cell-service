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
import java.util.stream.Collectors;

@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService {
    @Autowired
    CompanyDetailsRepo companyDetailsRepo;
    @Autowired
    ObjectMapper mapper;
    @Override
    public ResponseEntity<CompanyDetailsDto> createCompanyDetails(CompanyDetailsDto companyDetailsDto) {
        if(companyDetailsDto!=null) {
            CompanyDetails companyDetails = mapper.convertValue(companyDetailsDto, CompanyDetails.class);
            companyDetails = companyDetailsRepo.save(companyDetails);
            return new ResponseEntity<>(mapper.convertValue(companyDetails, CompanyDetailsDto.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<CompanyDetailsDto>> getAllCompanies() {
        return new ResponseEntity<>(companyDetailsRepo.findAll().stream()
                .map(company->mapper.convertValue(company, CompanyDetailsDto.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateCompanyDetails(CompanyDetailsDto companyDetailsDto) {
        Optional<CompanyDetails> companyDetails = companyDetailsRepo.findById(companyDetailsDto.getCompanyId());
        if(companyDetails.isPresent()){
            companyDetails.get().setCompanyInfo(companyDetailsDto.getCompanyInfo());
            companyDetails.get().setCompanyName(companyDetailsDto.getCompanyName());
            companyDetails.get().setSector(companyDetailsDto.getSector());
            companyDetails.get().setJobLocation(companyDetailsDto.getJobLocation());
            companyDetails.get().setOrgType(companyDetailsDto.getOrgType());
            companyDetails.get().setRole(companyDetailsDto.getRole());
            companyDetailsRepo.save(companyDetails.get());
            return new ResponseEntity<>("Company details updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company details update failed",HttpStatus.BAD_REQUEST);
    }

}
