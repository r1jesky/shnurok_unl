package ru.ssau.tk.shnurok.lab2.exeptions;

import java.lang.RuntimeException;

public class ArrayIsNotSortedException extends RuntimeException {
    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String message) {
        super(message);
    }
}
