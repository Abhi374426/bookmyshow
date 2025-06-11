package com.driver.bookMyShow.Dtos.ResponseDtos;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatArrangementResponseDto {
    private String seatName;
    private String seatType;
}
