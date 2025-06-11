package com.driver.bookMyShow.Exceptions;

public class NotFoundExecption extends RuntimeException{

    public NotFoundExecption(){
        super("Not found");
    }
    public NotFoundExecption(String msg){
        super(msg);
    }
}
