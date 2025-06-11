package com.driver.bookMyShow.Services;

import com.driver.bookMyShow.Dtos.RequestDtos.FacilityRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.FacilityResponseDto;

import java.util.List;

public interface FacilityService {
   FacilityResponseDto addFacilityv1(FacilityRequestDto facilityRequestDto);
   List<FacilityResponseDto> getAllFacilityv1();
   FacilityResponseDto updateFacilityv1(String facilityId , FacilityRequestDto facilityRequestDto);
   String   deleteFacilityv1(String facilityId);
   String   updateDefaultv1(String facilityId);
   FacilityResponseDto getFacilityByIdv1(String facilityId);
}
