package ru.ssau.tk.shnurok.lab2.exeptions;

import java.lang.RuntimeException;

public class DifferentLengthOfArraysException extends RuntimeException {
    public DifferentLengthOfArraysException() {
    }

    public DifferentLengthOfArraysException(String message) {
        super(message);
    }
}
