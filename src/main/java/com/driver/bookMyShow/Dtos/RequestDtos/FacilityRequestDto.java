package com.driver.bookMyShow.Dtos.RequestDtos;

import com.driver.bookMyShow.Enums.FacilityType;
import com.driver.bookMyShow.Exceptions.RequestFailedException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FacilityRequestDto {

    private String  facility;
    private String logo;

    public  void validate(){
        if ((facility==null ||facility.isEmpty())||(logo==null ||logo.isEmpty())){
            throw new RequestFailedException();
        }
        System.out.println("this is second validaion");
        FacilityType.validate(facility);
    }
}
