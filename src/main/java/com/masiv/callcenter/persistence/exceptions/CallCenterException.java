package com.masiv.callcenter.persistence.exceptions;

public class CallCenterException extends Exception {
    public static final String NOT_FOUND="Agente no registrado";
    public CallCenterException() {
        super();
    }
    public CallCenterException(String message) {
        super(message);
    }
}
