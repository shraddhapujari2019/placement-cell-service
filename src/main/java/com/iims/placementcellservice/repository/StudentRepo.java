package com.iims.placementcellservice.repository;

import com.iims.placementcellservice.entity.Student;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByUsername(String username);
    @Query( value = "SELECT * FROM STUDENT_INFO sd JOIN PLACEMENT_STATUS ps on sd.STUDENT_ID = ps.STUDENT_ID",
            nativeQuery = true)
    List<Student> getPlacedStudents();


}
