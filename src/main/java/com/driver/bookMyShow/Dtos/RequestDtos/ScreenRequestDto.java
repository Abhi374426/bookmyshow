package com.driver.bookMyShow.Dtos.RequestDtos;

import com.driver.bookMyShow.Enums.ScreenType;
import com.driver.bookMyShow.Exceptions.RequestFailedException;
import lombok.Getter;
import lombok.Setter;

//@Data
@Setter
@Getter
public class ScreenRequestDto {
    private String screenType;
//    private String theaterid;
//    private CapacitiveRequestDto capacitiveV1;

    public void validate(){
        if (screenType==null ||screenType.isEmpty()){
            throw new RequestFailedException();
        }
//        capacitiveV1.validate();
        ScreenType.validate(screenType);
        System.out.println("this is below this line ------------------");

    }
}
