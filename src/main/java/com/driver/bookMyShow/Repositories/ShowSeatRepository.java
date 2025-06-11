package com.driver.bookMyShow.Repositories;


import com.driver.bookMyShow.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,String> {

//    boolean existsByShowAndSeatType(Show show, String seatType);


}
