package com.apiumtech.tdd.kata;

public class NumberFilter {

    public String Filter(String stringInput) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splitString = stringInput.split(",");
        for (int i = 0; i < splitString.length; i++) {
            try {
                Integer.parseInt(splitString[i]);
                stringBuilder.append(splitString[i]);
                stringBuilder.append(",");
            } catch (NumberFormatException e) {
                // TODO: write log here
            }
        }
        if (stringBuilder.lastIndexOf(",") > -1) {
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        }
        return stringBuilder.toString();
    }
}
