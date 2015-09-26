package com.apiumtech.tdd.kata;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorValidatorTest {

    StringCalculatorValidator classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new StringCalculatorValidator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidateShouldReturnTrue() {
        try {
            final String inputString = "1\n2,3";
            final boolean validate = classUnderTest.Validate(inputString);

            Assert.assertTrue(validate);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testValidateShouldReturnFalseForCase1() {
        try {
            final String inputString = "1,\n,2";
            final boolean validate = classUnderTest.Validate(inputString);

            Assert.assertFalse(validate);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

    @Test
    public void testValidateShouldReturnFalseForCase2() {
        try {
            final String inputString = "1\n,2,3";
            final boolean validate = classUnderTest.Validate(inputString);

            Assert.assertFalse(validate);
        } catch (final Exception e) {
            fail("have an exception");
        }
    }

}
