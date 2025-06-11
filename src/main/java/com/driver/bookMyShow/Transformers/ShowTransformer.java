package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.RequestDtos.ShowRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ShowResponseDtos;
import com.driver.bookMyShow.Enums.ShowStatus;
import com.driver.bookMyShow.Models.Show;

public class ShowTransformer {

    public static Show  DtoTOObj( ShowRequestDto showRequestDto){
        return Show.builder()
                .showStatus(ShowStatus.getEnum("INITIATED").getSTATUS())
                .startTime(showRequestDto.getStartTime())
                .endTime(showRequestDto.getEndTime())
                .movies(null)
                .isActive(true)
                .deleted(false)
                .build();
    }
    public static ShowResponseDtos   ObjTODto(Show show){
        return ShowResponseDtos.builder()
                .id(show.getId())
                .startTime(show.getStartTime())
                .endTime(show.getEndTime())
                .screenId(show.getScreen().getId())
                .showStatus(show.getShowStatus())
                .build();
    }
}
