package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.RequestDtos.ScreenRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ScreenResponseDto;
import com.driver.bookMyShow.Enums.ScreenType;
import com.driver.bookMyShow.Models.Screen;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ScreenTransfomers {

    public static Screen  ScreenDtoToObj(ScreenRequestDto screenRequestDto){
          return    Screen.builder()
                  .screenType(ScreenType.getEnum(screenRequestDto.getScreenType()).getDisplayName())
                     .isActive(true)
                     .deleted(false)
                     .build();
    }
    public static ScreenResponseDto ObjToScreenDto(Screen screen){
        return ScreenResponseDto.builder()
                .id(screen.getId())
                .screenType(screen.getScreenType())
                .isActive(screen.getIsActive())
                .build();
    }
}
