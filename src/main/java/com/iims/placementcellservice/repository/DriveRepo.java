package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.Drive;
import com.iims.placementcellservice.model.CompanyDriveDto;
import com.iims.placementcellservice.model.DriveSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveRepo extends JpaRepository<Drive, Integer> {
//    @Query(value = "select new CompanyDriveDto(d.driveId, d.companyName, d.driveDate, d.driveLocation, d.offeredCtc) " +
//                    "from Drive d join CompanyDetails c ON d.companyId = c.companyId " +
//                    "join ApplicationStatus a ON a.driveId = d.driveId " +
//                    "where a.studentId = :studentId")
//    List<CompanyDriveDto> getAllDrives(@Param("studentId")long studentId);

    @Query(value = "SELECT DD.DRIVE_ID as driveId, CD.COMPANY_NAME as companyName, DD.DRIVE_DATE as driveDate, " +
            "DD.DRIVE_LOCATION as driveLocation, DD.OFFERED_CTC as offeredCtc " +
            "FROM drive_details DD JOIN company_details CD ON DD.COMPANY_ID = CD.COMPANY_ID " +
            "JOIN application_status AA ON AA.DRIVE_ID = DD.DRIVE_ID " +
            "JOIN STUDENT_INFO SI ON SI.STUDENT_ID = AA.STUDENT_ID WHERE SI.USERNAME = :username", nativeQuery = true)
    List<DriveSummary> getAllDrives(@Param("username")String username);

    @Query(value = "SELECT DD.DRIVE_ID as driveId, CD.COMPANY_NAME as companyName, DD.DRIVE_DATE as driveDate, " +
            "DD.DRIVE_LOCATION as driveLocation, DD.OFFERED_CTC as offeredCtc " +
            "FROM drive_details DD JOIN company_details CD ON DD.COMPANY_ID = CD.COMPANY_ID ", nativeQuery = true)
    List<DriveSummary> getAllDrivesWithCompany();
}