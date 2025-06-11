package com.driver.bookMyShow.Enums;

import com.driver.bookMyShow.Exceptions.InvalidType;

import java.util.Arrays;

public enum SeatType {
    GOLD,
    PLATINUM,
    RECLINER,
    COUPLERECLINER;

//    private String value;
//
//    SeatTypeV1(String type){
//        this.value = type;
//    }
    public static void validate(String type) {
        boolean isValid = Arrays.stream(SeatType.values())
                .anyMatch(seat -> seat.name().equalsIgnoreCase(type));
        if (!isValid) {
            throw new InvalidType("Invalid seat type: " + type);
        }
    }

    public static SeatType getEnum(String value) {
        validate(value);
        return SeatType.valueOf(SeatType.class, value.toLowerCase());
    }


}
