package com.apiumtech.tdd.kata;

import java.util.ArrayList;
import java.util.List;

public class NumberFilter {

    public String Filter(final String stringInput) {
        final List<Integer> negativeList = new ArrayList<Integer>();
        final StringBuilder stringBuilder = new StringBuilder();
        final String[] splitString = stringInput.split(",");
        for (int i = 0; i < splitString.length; i++) {
            try {
                final int number = Integer.parseInt(splitString[i]);
                if (number > 0 && number <= 1000) {
                    stringBuilder.append(splitString[i]);
                    stringBuilder.append(",");
                } else if (number < 0) {
                    negativeList.add(number);
                }
            } catch (final NumberFormatException e) {
                // TODO: write log here
            }
        }
        if (negativeList.size() > 0) {
            throw new RuntimeException("negatives not allowed - " + negativeList.toString());
        }
        if (stringBuilder.lastIndexOf(",") > -1) {
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        }
        return stringBuilder.toString();
    }
}
