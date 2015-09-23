package com.apiumtech.tdd.kata;

public class StringCalculator {

    public int Add(String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }

        int result = 0;
        NumberFilter numberFilter = new NumberFilter();
        StringCalculatorBuilder stringCalculatorBuilder = new StringCalculatorBuilder();
        StringCalculatorValidator stringCalculatorValidator = new StringCalculatorValidator();

        if (stringCalculatorValidator.Validate(numbers)) {
            String[] splitString = numberFilter.Filter(stringCalculatorBuilder.BuildStringNumber(numbers)).split(",");
            // TODO : need to refactor
            for (String number : splitString) {
                result = result + Integer.parseInt(number);
            }
        }

        return result;
    }
}
