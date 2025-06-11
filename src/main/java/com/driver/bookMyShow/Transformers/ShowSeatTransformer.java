package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.RequestDtos.ShowSeatRequestDto;
//import com.driver.bookMyShow.Dtos.ResponseDtos.ReturnShowSeatV1Dto;
import com.driver.bookMyShow.Dtos.ResponseDtos.SeatResponseDto;
import com.driver.bookMyShow.Models.ShowSeat;

public class ShowSeatTransformer {

    public static ShowSeat showSeatV1DtoToShowseatV1(ShowSeatRequestDto showSeatRequestDto) {
        ShowSeat showSeat = ShowSeat.builder()
                .seatType(showSeatRequestDto.getSeatType())
                .price(showSeatRequestDto.getPrice())
                .isActive(true)
                .deleted(false)

                .build();
        return showSeat;

    }

    public static SeatResponseDto returnShowSeatV1Dto(ShowSeat showSeat) {
        SeatResponseDto returnShowSeatV1Dto = SeatResponseDto.builder()
                .seatType(showSeat.getSeatType())
                .price(showSeat.getPrice())
                .build();
        return returnShowSeatV1Dto;
    }
}
