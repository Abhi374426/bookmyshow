package com.driver.bookMyShow.Enums;

import com.driver.bookMyShow.Dtos.ResponseDtos.ScreenResponseDto;
import com.driver.bookMyShow.Exceptions.InvalidType;

import java.util.Arrays;

public enum ScreenType {
    TWO_D("2D"),
    THREE_D("3D"),
    FOUR_DX("4DX"),
    IMAX("IMAX"),
    MX4D("MX4D");

    private final String displayName;

    ScreenType(String displayName) {
        this.displayName = displayName;
    }

    public  String getDisplayName() {
        return displayName;
    }
    public static void validate(String type){
        boolean isValid= Arrays.stream(ScreenType.values())
                .anyMatch(screenType ->  screenType.name().equalsIgnoreCase(type));
        if (!isValid){
            throw new InvalidType("Invalid Screen type :"+type);
        }
    }

    public static   ScreenType getEnum(String enumValue){
        return  Arrays.stream(ScreenType.values()).filter(screenType -> screenType.name().equalsIgnoreCase(enumValue))
                .findFirst().orElseThrow(() -> new InvalidType("Invalid Screen type :" + enumValue));
    }




}
