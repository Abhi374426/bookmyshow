package com.driver.bookMyShow.Transformers;

import com.driver.bookMyShow.Dtos.ResponseDtos.SeatArrangementResponseDto;
import com.driver.bookMyShow.Models.SeatingArrangement;

import java.util.List;
import java.util.stream.Collectors;

public class SeatArrangementResponse {
    public static List<SeatArrangementResponseDto> seatArrangementReturnDto(List<SeatingArrangement> seatingArrangementList) {
        return seatingArrangementList.stream()
                .map(seating -> SeatArrangementResponseDto.builder()
                        .seatName(seating.getSeatName())
                        .seatType(seating.getSeatType())
                        .build()
                )
                .collect(Collectors.toList());
    }


}
