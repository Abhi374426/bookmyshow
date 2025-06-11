package com.driver.bookMyShow.Exceptions;

public class InvalidType extends RuntimeException {
    public InvalidType() {
        super("Invalid Seat Type");
    }

    public InvalidType(String msg) {
        super(msg);
    }
}
