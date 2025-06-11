package com.driver.bookMyShow.Repositories;

import com.driver.bookMyShow.Models.TheaterFacility;
import com.driver.bookMyShow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterFacilityRepository extends JpaRepository<TheaterFacility,String> {
    Optional<TheaterFacility> findByTheater_IdAndFacility_Id(String theaterId, String facilityId);
     void deleteByFacility_Id(String facilityId);
     void deleteByTheater(Theater theater);
     List<TheaterFacility> findByFacility_Id(String facilityId);
}
