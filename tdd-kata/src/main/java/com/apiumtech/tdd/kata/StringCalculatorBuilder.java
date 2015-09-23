package com.apiumtech.tdd.kata;

public class StringCalculatorBuilder {

    public String BuildStringNumber(String inputString) {
        return inputString.replaceAll(Constants.NEW_LINE, Constants.COMMAS);
    }
}
