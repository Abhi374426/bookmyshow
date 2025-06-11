package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterReturnDto;
import com.driver.bookMyShow.Models.TheaterFacility;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TheaterFacilityTransformer {

    public static TheaterReturnDto TheaterFacilityToDto(TheaterFacility theaterFacilities){
        return TheaterReturnDto.builder()
                 .name(theaterFacilities.getFacility().getFacility())
                 .logo(theaterFacilities.getFacility().getLogo())
                 .isAcitve(theaterFacilities.getIsActive())
                 .build();


    }
}
