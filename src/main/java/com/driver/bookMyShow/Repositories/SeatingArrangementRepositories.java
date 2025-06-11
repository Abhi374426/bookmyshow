package com.driver.bookMyShow.Repositories;

import com.driver.bookMyShow.Models.SeatingArrangement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatingArrangementRepositories extends JpaRepository<SeatingArrangement,String> {
    List<SeatingArrangement> findByScreen_Id(String screenId);

    boolean existsByScreen_Id(String screenId);
}
