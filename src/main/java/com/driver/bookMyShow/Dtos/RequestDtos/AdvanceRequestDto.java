package com.driver.bookMyShow.Dtos.RequestDtos;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class AdvanceRequestDto {
    private Date date;
    private String advanceType;
    private String vechicleType;
    private String routeName;
    private String status;
    private String vendor;
    private Double amount;
    private String action;
    private Long userIdCreation;
    private Long userIdUpdation;

}
