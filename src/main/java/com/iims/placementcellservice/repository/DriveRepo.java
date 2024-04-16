package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.CompanyDetails;
import com.iims.placementcellservice.entity.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriveRepo extends JpaRepository<Drive, Long> {
    Optional<Drive> findByDriveId(Long driveId);
}
