package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.PlacementStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlacementStatusRepo extends JpaRepository<PlacementStatus, Long> {
}
