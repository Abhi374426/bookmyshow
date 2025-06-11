package com.driver.bookMyShow.Dtos.ResponseDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponseDtos {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String screenId;
    @JsonIgnore
    private String movieId;

    private String showStatus;

}
