package com.apiumtech.tdd.kata;

public class StringCalculator {

    public int Add(String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }

        NumberFilter numberFilter = new NumberFilter();
        String[] splitString = numberFilter.Filter(numbers).split(",");

        int result = 0;

        // TODO : need to refactor
        for (String number : splitString) {
            result = result + Integer.parseInt(number);
        }

        return result;
    }
}
