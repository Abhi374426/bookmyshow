package com.driver.bookMyShow.Services;

import com.driver.bookMyShow.Dtos.RequestDtos.ScreenRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ScreenResponseDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterReturnDto;
import com.driver.bookMyShow.Models.Facility;
import com.driver.bookMyShow.Models.TheaterFacility;

import java.util.List;

public interface TheaterFacilityService {
 List<TheaterFacility> addFacilityToTheater(String theaterId, List<Facility> facilities);
 TheaterReturnDto  toggelForTheater(String theaterId,String Facility);
 void addFacilityOnTheater(String theaterId,String FacilityId);

}
