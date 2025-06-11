package com.driver.bookMyShow.Enums;

import com.driver.bookMyShow.Exceptions.InvalidType;

import java.util.Arrays;

public enum Genre {
    DRAMA("Drama"),
    THRILLER("Thriller"),
    ACTION("Action"),
    ROMANTIC("Romantic"),
    COMEDY("Comedy"),
    HISTORICAL("Historical"),
    ANIMATION("Animation"),
    SPORTS("Sports"),
    SOCIAL("Social"),
    WAR("War");

    private final String displayName;

    Genre(String displayName){
        this.displayName=displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
    public static void validation(String type){
        boolean isValid= Arrays.stream(Genre.values())
                .anyMatch(genre -> genre.name().equalsIgnoreCase(type));
        if (!isValid){
            throw new InvalidType("Genre Invalid type:"+type);
        }
    }
}
