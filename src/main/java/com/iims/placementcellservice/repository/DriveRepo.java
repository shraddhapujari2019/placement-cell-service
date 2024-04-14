package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.entity.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriveRepo extends JpaRepository<Drive, Long> {
}
