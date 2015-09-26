package com.apiumtech.tdd.kata;

import org.apache.commons.lang3.StringUtils;

public class StringCalculatorBuilder {

    public String BuildStringNumber(final String inputString) {
        if (inputString.startsWith("//")) {
            final int delimiterIndex = inputString.indexOf("//") + 2;
            final int newLineIndex = inputString.indexOf(Constants.NEW_LINE);
            String delimiter = ";";
            if (inputString.startsWith("//[")) {
                delimiter = inputString.substring(delimiterIndex + 1, newLineIndex - 1);
            } else {
                delimiter = inputString.substring(delimiterIndex, newLineIndex);
            }
            final String stringNumbers = inputString.substring(inputString.indexOf(Constants.NEW_LINE) + 1);
            return StringUtils.replace(stringNumbers, delimiter, Constants.COMMAS);
        }
        return inputString.replaceAll(Constants.NEW_LINE, Constants.COMMAS);
    }
}
