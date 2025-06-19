package com.driver.bookMyShow.Repositories;

import com.driver.bookMyShow.Models.AdvanceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AdvanceDataRepo extends JpaRepository<AdvanceData,Long> {
    @Query("SELECT e FROM AdvanceData e "+
    "WHERE (:date IS NULL OR e.date =:date)"+
    "AND(:advaceType IS NULL OR e.advanceType =:advanceType)"+
    "AND(:vechicleType IS NULL OR e.vechicleType=:vechicleType)"+
    "AND(:routeName IS NULL OR e.routeName=:routeName)"+
    "AND (:status IS NULL OR e.status=:status)"+
    "AND (:vendor IS NULL OR e.vendor=:vendor)")
    List<AdvanceData>  searchData(@Param("date")Date date,
                                  @Param("advanceType") String advanceType,
                                  @Param("vechicleType") String vechicleType,
                                  @Param("routeName") String routeName,
                                  @Param("status") String status,
                                  @Param("vendor") String vendor);
}
