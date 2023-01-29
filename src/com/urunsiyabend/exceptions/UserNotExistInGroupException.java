package com.urunsiyabend.exceptions;

public class UserNotExistInGroupException extends Exception{
    public UserNotExistInGroupException() {
        super();
    }

    public UserNotExistInGroupException(String message) {
        super(message);
    }
}
