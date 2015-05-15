package edu.neumont.java.example;

public class Calculator {
    public Integer multiply(Integer a, Integer b) {
        if ( a == null || b == null ) throw new IllegalArgumentException("Both a and b must not be null!");

        return a * b;
    }
}
