package com.masiv.callcenter.persistence.exceptions;

public class CallCenterPersistenceException extends Exception{

    public CallCenterPersistenceException(String message){
        super(message);
    }

    public CallCenterPersistenceException(String message, Throwable cause){
        super(message,cause);
    }
}
