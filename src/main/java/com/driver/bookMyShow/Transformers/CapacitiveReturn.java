package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.ResponseDtos.CapacitiveResponseDto;
import com.driver.bookMyShow.Models.Capacitive;

public class CapacitiveReturn {

    public static CapacitiveResponseDto returnCapacitiveDto(Capacitive capacitive){
                     return   CapacitiveResponseDto.builder()
                               .gold(capacitive.getGold())
                               .silver(capacitive.getSilver())
                               .diamond(capacitive.getDiamond())
                               .build();
    }
}
