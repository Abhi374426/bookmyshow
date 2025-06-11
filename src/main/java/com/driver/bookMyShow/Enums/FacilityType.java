package com.driver.bookMyShow.Enums;

import com.driver.bookMyShow.Exceptions.InvalidType;

import java.util.Arrays;

public enum FacilityType {
    TICKET_CANCEL("Ticket Cancel"),
    F_AND_B("F&B"),
    M_TICKET("M-Ticket"),
    GAMING_ZONE("Gaming Zone"),
    WHEEL_CHAIR("Wheel Chair"),
    PARKING("Parking");

    private final String displayName;

    FacilityType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static void validate(String type) {
        boolean isValid = Arrays.stream(FacilityType.values())
                .anyMatch(facilityType -> facilityType.name().equalsIgnoreCase(type));
        if (!isValid) {
            throw new InvalidType("Invalid Facility type: " + type);
        }
    }
}
