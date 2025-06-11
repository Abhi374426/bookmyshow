package com.driver.bookMyShow.Repositories;

import com.driver.bookMyShow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show,String> {
    List<Show> findByScreen_IdAndStartTimeLessThanAndEndTimeGreaterThan(
            String screenId,
            LocalDateTime newEndTime,
            LocalDateTime newStartTime
    );
    List<Show> findByScreenId(String screenId);
    List<Show> findByMoviesId(String movieId);
}
