package ru.ssau.tk.shnurok.lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MathFunctionDTO {
    private int id;
    private String functionName;
    private int count;
    private double xFrom;
    private double xTo;
}