package com.driver.bookMyShow.Dtos.ResponseDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScreenResponseDto {
    private String  id;
    private String screenType;
    private boolean isActive;
    @JsonIgnore
    private boolean Deleted;
    @JsonIgnore
    private CapacitiveResponseDto capacitive;
    @JsonIgnore
    private List<SeatArrangementResponseDto> seatArrangement;
}
