package com.apiumtech.tdd.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorBuilderTest {

    StringCalculatorBuilder classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new StringCalculatorBuilder();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBuildStringNumberShouldSuccessful() {
        try {
            final String inputString = "1\n2,3";
            final String stringBuildResult = classUnderTest.BuildStringNumber(inputString);

            assertEquals("1,2,3", stringBuildResult);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testBuildStringNumberShouldSuccessfulWithDelimiters() {
        try {
            final String inputString = "//;\n1;2";
            final String stringBuildResult = classUnderTest.BuildStringNumber(inputString);

            assertEquals("1,2", stringBuildResult);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testBuildStringNumberShouldSuccessfulWithAnyLengthDelimiters() {
        try {
            final String inputString = "//[***]\n1***2***3";
            final String stringBuildResult = classUnderTest.BuildStringNumber(inputString);

            assertEquals("1,2,3", stringBuildResult);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testBuildStringNumberShouldSuccessfulWithMultipleDelimiters() {
        try {
            final String inputString = "//[*][%]\n1*2%3";
            final String stringBuildResult = classUnderTest.BuildStringNumber(inputString);

            assertEquals("1,2,3", stringBuildResult);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testBuildStringNumberShouldSuccessfulWithMultipleDelimitersAndAnyLengthOfDelimiters() {
        try {
            final String inputString = "//[***][%%%]\n1***2%%%3";
            final String stringBuildResult = classUnderTest.BuildStringNumber(inputString);

            assertEquals("1,2,3", stringBuildResult);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testBuildDelimiterListShouldSuccessful() {
        try {
            final String inputString = "//[*][%]\n1*2%3";
            final List<String> stringBuildResult = classUnderTest.BuildDelimiterList(inputString);

            assertEquals(2, stringBuildResult.size());
            assertEquals("*", stringBuildResult.get(0));
            assertEquals("%", stringBuildResult.get(1));
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testBuildDelimiterListShouldSuccessfulWithDelimiterIsEmpty() {
        try {
            final String inputString = "1,2,3";
            final List<String> stringBuildResult = classUnderTest.BuildDelimiterList(inputString);

            assertEquals(0, stringBuildResult.size());
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testBuildDelimiterListShouldSuccessfulWithMissingOpenTag() {
        try {
            final String inputString = "//*]%]\n1*2%3";
            final List<String> stringBuildResult = classUnderTest.BuildDelimiterList(inputString);

            assertEquals(0, stringBuildResult.size());
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testBuildDelimiterListShouldSuccessfulWithMissingCloseTag() {
        try {
            final String inputString = "//[*[%\n1*2%3";
            final List<String> stringBuildResult = classUnderTest.BuildDelimiterList(inputString);

            assertEquals(0, stringBuildResult.size());
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

}
