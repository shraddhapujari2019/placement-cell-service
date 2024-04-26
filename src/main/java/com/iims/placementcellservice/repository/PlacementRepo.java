package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.PlacementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepo extends JpaRepository<PlacementStatus, Long> {
}
