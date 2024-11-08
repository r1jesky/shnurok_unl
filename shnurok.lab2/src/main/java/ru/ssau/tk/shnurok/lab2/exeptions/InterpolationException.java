package ru.ssau.tk.shnurok.lab2.exeptions;

import java.lang.RuntimeException;

public class InterpolationException extends RuntimeException {
    public InterpolationException() {
    }

    public InterpolationException(String message) {
        super(message);
    }
}
