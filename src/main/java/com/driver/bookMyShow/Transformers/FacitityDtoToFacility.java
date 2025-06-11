package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.RequestDtos.FacilityRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.FacilityResponseDto;
import com.driver.bookMyShow.Models.Facility;

public class FacitityDtoToFacility {

    public static Facility facilityDtoToFacilityv1(FacilityRequestDto facilityRequestDto){
            return Facility.builder()
                     .facility(facilityRequestDto.getFacility())
                     .logo(facilityRequestDto.getLogo())
                     .isActive(true)
                     .deleted(false)
                     .build();
    }
    public static FacilityResponseDto facilityToReturnDtov1(Facility facility){

             return    FacilityResponseDto.builder()
                     .Id(facility.getId())
                     .name(facility.getFacility())
                     .logo(facility.getLogo())
                     .isActive(facility.getIsActive())
                     .deleted(facility.getDeleted())
                     .build();
    }
}
