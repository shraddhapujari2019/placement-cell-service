package com.iims.placementcellservice.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.model.CompanyDetailsDto;
import org.mapstruct.Mapper;

@Mapper
@JsonIgnoreProperties(ignoreUnknown = true)
public interface CompanyDetailsMapper {
    CompanyDetails toCompanyDetails(CompanyDetailsDto companyDetailsDto);
    CompanyDetailsDto toCompanyDetailsDto(CompanyDetails companyDetails);
}
