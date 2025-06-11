package com.driver.bookMyShow.Dtos.ResponseDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacilityResponseDto {

    private String Id;
    private String name;
    private String logo;
    @JsonIgnore
    private boolean deleted;
    @JsonIgnore
    private String createDate;
    @JsonIgnore
    private String updateDate;

    private boolean isActive;
}
