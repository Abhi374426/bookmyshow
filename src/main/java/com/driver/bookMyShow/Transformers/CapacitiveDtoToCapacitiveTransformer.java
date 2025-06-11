package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.RequestDtos.CapacitiveRequestDto;
import com.driver.bookMyShow.Models.Capacitive;

public class CapacitiveDtoToCapacitiveTransformer {

    public  static Capacitive dtoToObj(CapacitiveRequestDto capacitiveRequestDto){
                   return      Capacitive.builder()
                                .gold(capacitiveRequestDto.getGold())
                                .diamond(capacitiveRequestDto.getDiamond())
                                .silver(capacitiveRequestDto.getSilver())
                           .isActive(true)
                           .deleted(false)

                                .build();

    }
}
