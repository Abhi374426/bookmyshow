package com.driver.bookMyShow.Dtos.RequestDtos;

import com.driver.bookMyShow.Exceptions.RequestFailedException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ShowRequestDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public void validate() {
        // Validate if both startTime and endTime are not null
        if (startTime == null) {
            throw new RequestFailedException("Start time cannot be null");
        }
        if (endTime == null) {
            throw new RequestFailedException("End time cannot be null");
        }

        // Validate if startTime is before endTime
        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new RequestFailedException("Start time must be before end time");
        }
    }

}
