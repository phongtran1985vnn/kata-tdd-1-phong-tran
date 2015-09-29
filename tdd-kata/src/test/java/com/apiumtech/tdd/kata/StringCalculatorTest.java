package com.apiumtech.tdd.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    StringCalculator classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new StringCalculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddShouldSuccessfulWithEmptyString() {
        final String numbers = "";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(0, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithOneNumber() {
        final String numbers = "1";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(1, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithTwoNumber() {
        final String numbers = "1,2";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(3, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithNumbersContainCharacter() {
        final String numbers = "1,a,2,3";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(6, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithNumbersContainCharacterAndNewLine() {
        final String numbers = "1,a\n2,3";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(6, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithNumbersContainCharacterAndNewLineAndValidateTrue() {
        final String numbers = "1\n2,3";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(6, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithNumbersContainCharacterAndNewLineAndValidateFalse() {
        final String numbers = "1,\n2,3";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(0, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithDelimiters() {
        final String numbers = "//;\n1;2;7";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(10, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test(expected = RuntimeException.class)
    public void testAddShouldThrowException() {
        final String numbers = "1,-2,7,-3,-8,9";
        classUnderTest.Add(numbers);
    }

    @Test
    public void testAddShouldThrowExceptionWithMessage() {
        final String numbers = "1,-2,7,-3,-8,9";
        try {
            classUnderTest.Add(numbers);
        } catch (final Exception e) {
            Assert.assertNotNull(e);
            assertEquals("negatives not allowed - [-2, -3, -8]", e.getMessage());
        }
    }

    @Test
    public void testAddShouldSuccessfulIgnoreBiggerThan1000() {
        final String numbers = "1,1000,2,3,2001,1023,4";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(1010, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithAnyLengthDelimiters() {
        final String numbers = "//[***]\n1***2***3";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(6, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testAddShouldSuccessfulWithMultipleDelimiters() {
        final String numbers = "//[*][%]\n1*2%3";
        try {
            final int stringCalculator = classUnderTest.Add(numbers);

            assertEquals(6, stringCalculator);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }
}
