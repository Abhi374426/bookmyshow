package com.driver.bookMyShow.Dtos.ResponseDtos;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterReturnDto {

    private String name;
    private String logo;
    private Boolean isAcitve;

}
