package com.masiv.callcenter.persistence.exceptions;

public class CallCenterNotFoundException extends Exception{

    public CallCenterNotFoundException(String message){
        super(message);
    }

    public CallCenterNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
