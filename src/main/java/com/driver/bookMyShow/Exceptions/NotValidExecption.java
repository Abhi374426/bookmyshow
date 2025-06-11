package com.driver.bookMyShow.Exceptions;

public class NotValidExecption extends RuntimeException{

    public NotValidExecption(){
        super("Not Valid");
    }
    public NotValidExecption(String msg){
        super(msg);
    }
}
