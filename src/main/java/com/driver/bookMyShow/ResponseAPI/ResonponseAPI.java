package com.driver.bookMyShow.ResponseAPI;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResonponseAPI<T> {

    private String message;
    private int status;
    private T data;



}
