package com.driver.bookMyShow.Dtos.ResponseDtos;

import lombok.*;

import java.util.List;

//@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterResponseDto {

    private String id ;
    private String name;
    private String address;

    private List<TheaterReturnDto> facilityList;









}
