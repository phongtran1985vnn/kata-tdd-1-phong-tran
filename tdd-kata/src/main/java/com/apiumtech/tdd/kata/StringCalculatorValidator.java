package com.apiumtech.tdd.kata;

public class StringCalculatorValidator {

    public boolean Validate(String inputString) {
        boolean result = true;

        if (inputString.contains(",\n") || inputString.contains("\n,")) {
            return false;
        }

        return result;
    }
}
