package com.driver.bookMyShow.Exceptions;

public class AlreadyPresentException extends RuntimeException{
        public AlreadyPresentException() {
            super("already Present!");
        }

    public AlreadyPresentException(String msg) {
        super(msg);
    }
}
