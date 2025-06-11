package com.driver.bookMyShow.Repositories;

import com.driver.bookMyShow.Models.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacilityRepository extends JpaRepository<Facility,String> {
    boolean existsByFacility(String facility);
        Optional<Facility> findByFacility(String facility);
//    @Query(value = "SELECT * FROM facility WHERE id = ?1 AND IS_ACTIVE = 'FALSE'",nativeQuery = true)
//    Optional<Facility> findByIdNative(@Param("ooo") String id);

}
