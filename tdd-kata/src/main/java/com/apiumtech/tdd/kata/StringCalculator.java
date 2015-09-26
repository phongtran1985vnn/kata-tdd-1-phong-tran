package com.apiumtech.tdd.kata;

public class StringCalculator {

    public int Add(final String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }

        int result = 0;
        final NumberFilter numberFilter = new NumberFilter();
        final StringCalculatorBuilder stringCalculatorBuilder = new StringCalculatorBuilder();
        final StringCalculatorValidator stringCalculatorValidator = new StringCalculatorValidator();

        if (stringCalculatorValidator.Validate(numbers)) {
            final String[] splitString = numberFilter.Filter(stringCalculatorBuilder.BuildStringNumber(numbers)).split(",");
            // TODO : need to refactor
            for (final String number : splitString) {
                result = result + Integer.parseInt(number);
            }
        }

        return result;
    }
}
