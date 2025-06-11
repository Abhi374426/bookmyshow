package com.driver.bookMyShow.Dtos.RequestDtos;

import com.driver.bookMyShow.Enums.SeatType;
import com.driver.bookMyShow.Exceptions.RequestFailedException;
import lombok.Data;

@Data
public class ShowSeatRequestDto {

    private String seatType;
    private Integer price;

    public void validate() {
        if (seatType == null || seatType.isEmpty() || price < 50 || price > 2000) {
            throw new RequestFailedException();
        }
        SeatType.validate(seatType);
    }
}
