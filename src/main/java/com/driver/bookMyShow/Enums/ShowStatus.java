package com.driver.bookMyShow.Enums;

import com.driver.bookMyShow.Exceptions.InvalidType;
import com.driver.bookMyShow.constant.Messages;

import java.util.Arrays;

public enum ShowStatus {
    INITIATED("initial") {
        @Override
        public String getDescription() {
            return Messages.getMessageWithDesc(Messages.SHOW, Messages.INITIATED);
        }
    },

    RUNNING("running") {
        @Override
        public String getDescription() {
            return Messages.getMessageWithDesc(Messages.SHOW, Messages.RUNNING);
        }
    },
    COMPLETED("completed") {
        @Override
        public String getDescription() {
            return Messages.getMessageWithDesc(Messages.SHOW, Messages.COMPLETED);
        }
    };

    private final String STATUS;

    ShowStatus(String STATUS){
        this.STATUS=STATUS;
    }
    public String getSTATUS(){
        return STATUS;
    }
    public static void validate(String status){
        boolean isValid= Arrays.stream(ShowStatus.values())
                .anyMatch(showStatus -> showStatus.name().equalsIgnoreCase(status));
        if (!isValid){
            throw new InvalidType(ShowStatus.getInvalidMsg());
        }
    }
    public static ShowStatus getEnum(String enumValues){
        return Arrays.stream(ShowStatus.values()).filter(showStatus -> showStatus.name().equalsIgnoreCase(enumValues))
                .findFirst().orElseThrow(()->new InvalidType("Invalid Show Status"+enumValues));
    }

    public abstract String getDescription();

    public static String getInvalidMsg() {
        return Messages.INVALID + Messages.ONE_TAB + Messages.SHOW +  Messages.ONE_TAB+Messages.TYPE+Messages.DOT;
    }
}
