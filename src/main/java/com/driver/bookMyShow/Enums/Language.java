package com.driver.bookMyShow.Enums;

import com.driver.bookMyShow.Exceptions.InvalidType;

import java.util.Arrays;

public enum Language {
    HINDI("Hindi"),
    ENGLISH("English"),
    TELUGU("Telugu"),
    TAMIL("Tamil"),
    MARATHI("Marathi"),
    PUNJAB("Punjab"),
    KANNADA("Kannada");

    private final String displayName;

    Language(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
    public static void validate(String type){
        boolean isValid= Arrays.stream(Language.values())
                .anyMatch(Language->Language.name().equalsIgnoreCase(type));
        if (!isValid){
            throw new InvalidType("Invaild Language :"+type);
        }
    }
}
