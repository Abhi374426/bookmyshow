package com.driver.bookMyShow.Repositories;

import com.driver.bookMyShow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,String> {

    Boolean existsByAddress(String address);
//    boolean existsByTheaterAndFacility(TheaterV1 theater, Facility facility);

}

