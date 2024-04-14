package com.iims.placementcellservice.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iims.placementcellservice.entity.Drive;
import com.iims.placementcellservice.model.DriveDto;
import org.mapstruct.Mapper;

@Mapper
@JsonIgnoreProperties(ignoreUnknown = true)
public interface DriveMapper {
    Drive toDrive(DriveDto driveDto);
    DriveDto toDriveDto(Drive drive);
}
