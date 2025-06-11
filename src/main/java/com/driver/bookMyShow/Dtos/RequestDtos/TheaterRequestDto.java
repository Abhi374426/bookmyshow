package com.driver.bookMyShow.Dtos.RequestDtos;

import com.driver.bookMyShow.Exceptions.RequestFailedException;
import lombok.Data;

import java.util.List;

@Data
public class TheaterRequestDto {

    private String name;

    private String  address;

    private List<String> facilityList;

    public void validate(){
        if ((name==null || name.isEmpty()) || (address ==  null || address.isEmpty())||(facilityList.isEmpty())){
            throw new RequestFailedException();
        }
        //name validation
       validate(name, address);
    }
    private void validate(String name, String address) {
        if (name.length() < 3)
            throw new RequestFailedException("Name is too short!");

        if (address.length()>50)
            throw new RequestFailedException("Address is too long!");
    }

}
