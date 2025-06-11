package com.driver.bookMyShow.Dtos.RequestDtos;

import com.driver.bookMyShow.Exceptions.RequestFailedException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CapacitiveRequestDto {
    private int diamond;
    private int gold;
    private int silver;

    public  void validate(){
        if (diamond<10||gold<10||silver<10){
            throw new RequestFailedException();
        }
    }



}
