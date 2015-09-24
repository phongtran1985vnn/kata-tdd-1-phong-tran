package com.apiumtech.tdd.kata;

public class StringCalculatorBuilder {

    public String BuildStringNumber(String inputString) {
        if (inputString.startsWith("//")) {
            int delimiterIndex = inputString.indexOf("//") + 2;
            String delimiter = inputString.substring(delimiterIndex, delimiterIndex + 1);
            String stringNumbers = inputString.substring(inputString.indexOf(Constants.NEW_LINE) + 1);
            return stringNumbers.replaceAll(delimiter, Constants.COMMAS);
        }
        return inputString.replaceAll(Constants.NEW_LINE, Constants.COMMAS);
    }
}
