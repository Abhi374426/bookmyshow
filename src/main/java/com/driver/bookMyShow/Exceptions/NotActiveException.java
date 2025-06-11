package com.driver.bookMyShow.Exceptions;

public class NotActiveException extends RuntimeException{

    public NotActiveException(){
        super("Not active");
    }
    public NotActiveException(String msg){
        super(msg);
    }

}
