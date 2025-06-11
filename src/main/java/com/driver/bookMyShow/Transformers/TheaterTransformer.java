package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.RequestDtos.TheaterRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterResponseDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterReturnDto;
import com.driver.bookMyShow.Models.Theater;

import java.util.List;

//import static jdk.internal.classfile.impl.DirectCodeBuilder.build;

public class TheaterTransformer {

    public static Theater TheaterV1EntryDtoToTheaterV1(TheaterRequestDto theaterRequestDto){

               Theater theater =     Theater.builder()
                            .address(theaterRequestDto.getAddress())
                            .name(theaterRequestDto.getName())

                       .isActive(true)
                       .deleted(false)

                       .build();

               return theater;
    }
    public static TheaterResponseDto ThearteV1ToReturnThaterV1Dto(Theater theater){
        List<TheaterReturnDto> theaterFacilities=  theater.getTheaterFacilities().stream()
                .filter(facility -> !facility.getDeleted())
              .map(TheaterFacilityTransformer::TheaterFacilityToDto)
              .toList();
        return TheaterResponseDto.builder()
                .id(theater.getId())
                .name(theater.getName())
                .address(theater.getAddress())
                .facilityList(theaterFacilities)
                .build();

//                              .getFacilityList().stream().map(FacitityDtoToFacility::facilityToReturnDto).collect(Collectors.toList()))
//                      .screenV1ReturnList(ScreenV1ReturnTransformer.screenV1Return(theaterV1.getScreenV1s()))

    }
}
