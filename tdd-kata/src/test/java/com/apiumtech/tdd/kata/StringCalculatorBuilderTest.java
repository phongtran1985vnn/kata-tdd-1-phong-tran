package com.apiumtech.tdd.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
            String inputString = "1\n2,3";
            String stringBuildResult = classUnderTest.BuildStringNumber(inputString);

            assertEquals("1,2,3", stringBuildResult);
        } catch (Exception e) {
            fail("have an exception");
        }
    }
    
    @Test
    public void testBuildStringNumberShouldSuccessfulWithDelimiters() {
        try {
            String inputString = "//;\n1;2";
            String stringBuildResult = classUnderTest.BuildStringNumber(inputString);

            assertEquals("1,2", stringBuildResult);
        } catch (Exception e) {
            fail("have an exception");
        }
    }

}
