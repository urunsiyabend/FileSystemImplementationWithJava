package com.urunsiyabend.exceptions;

public class FileAlreadyExistsException extends Exception{
    public FileAlreadyExistsException() {
        super();
    }

    public FileAlreadyExistsException(String message) {
        super(message);
    }
}
