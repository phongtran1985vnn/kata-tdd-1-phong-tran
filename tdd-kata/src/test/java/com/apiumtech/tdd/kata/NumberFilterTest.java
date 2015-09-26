package com.apiumtech.tdd.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberFilterTest {

    NumberFilter classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new NumberFilter();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFilterShouldSuccessful() {
        final String stringInput = "1,a,2,b,3";
        try {
            final String numberStringResult = classUnderTest.Filter(stringInput);

            assertEquals("1,2,3", numberStringResult);
        } catch (final Exception e) {
            fail("have an exception");
        }

    }

    @Test
    public void testFilterShouldSuccessfulWithOneChar() {
        final String stringInput = "a";
        try {
            final String nuberStringResult = classUnderTest.Filter(stringInput);

            assertEquals("", nuberStringResult);
        } catch (final Exception e) {
            fail("have an exception");
        }

    }

    @Test
    public void testFilterShouldSuccessfulWithCommas() {
        final String stringInput = ",";
        try {
            final String nuberStringResult = classUnderTest.Filter(stringInput);

            assertEquals("", nuberStringResult);
        } catch (final Exception e) {
            fail("have an exception");
        }

    }

    @Test(expected = RuntimeException.class)
    public void testFilterShouldThrowException() throws Exception {
        final String stringInput = "1,2,-5,4,-8,6";
        classUnderTest.Filter(stringInput);
    }

    @Test
    public void testFilterShouldThrowExceptionWithMessage() {
        final String stringInput = "1,2,-5,4,-8,6";
        try {
            classUnderTest.Filter(stringInput);
        } catch (final Exception e) {
            Assert.assertNotNull(e);
            assertEquals("negatives not allowed - [-5, -8]", e.getMessage());
        }

    }

    @Test
    public void testFilterShouldSuccessfulIgnoreBiggerThan1000() {
        final String stringInput = "1,2,1000,1001,1021,6";
        try {
            final String numberStringResult = classUnderTest.Filter(stringInput);

            assertEquals("1,2,1000,6", numberStringResult);
        } catch (final Exception e) {
            fail("have an exception");
        }

    }

}
