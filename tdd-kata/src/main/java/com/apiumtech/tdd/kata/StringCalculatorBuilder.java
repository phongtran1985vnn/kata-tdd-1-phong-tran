package com.apiumtech.tdd.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringCalculatorBuilder {

    public String BuildStringNumber(final String inputString) {
        if (inputString.startsWith("//")) {
            final int delimiterIndex = inputString.indexOf("//") + 2;
            final int newLineIndex = inputString.indexOf(Constants.NEW_LINE);
            String delimiter = ";";
            List<String> delimiterList = new ArrayList<String>();
            if (inputString.startsWith("//[")) {
                delimiterList = BuildDelimiterList(inputString);
            } else {
                delimiter = inputString.substring(delimiterIndex, newLineIndex);
            }
            final String stringNumbers = inputString.substring(inputString.indexOf(Constants.NEW_LINE) + 1);
            if (delimiterList.size() > 0) {
                String stringResult = stringNumbers;
                for (final String delimiterItem : delimiterList) {
                    stringResult = StringUtils.replace(stringResult, delimiterItem, Constants.COMMAS);
                }
                return stringResult;
            } else {
                return StringUtils.replace(stringNumbers, delimiter, Constants.COMMAS);
            }
        }
        return inputString.replaceAll(Constants.NEW_LINE, Constants.COMMAS);
    }

    public List<String> BuildDelimiterList(final String inputString) {
        final List<String> result = new ArrayList<String>();
        final String regularOpen = "\\[";
        final String regularClose = "\\]";
        final Pattern patternOpen = Pattern.compile(regularOpen);
        final Pattern patternClose = Pattern.compile(regularClose);
        final Matcher matcherOpen = patternOpen.matcher(inputString);
        final Matcher matcherClose = patternClose.matcher(inputString);

        while (matcherOpen.find() && matcherClose.find()) {
            final String delimiter = inputString.substring(matcherOpen.end(), matcherClose.start());
            result.add(delimiter);
        }

        return result;
    }
}
