package com.hades.fastlanecircle;

import com.hades.fastlanecircle.utils.ValidatorForInput;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PhoneUnitTest {

    /**
     * Correct Input
     */
    @Test
    public void phoneValidator_CorrectPhoneSimple_ReturnsTrue() {
        assertTrue(ValidatorForInput.isValidPhoneNumber("1234567890"));
    }

    @Test
    public void phoneValidator_Correct_Example1() {
        assertTrue(ValidatorForInput.isValidPhoneNumber("(123)4567890"));
    }

    @Test
    public void phoneValidator_Correct_Example2() {
        assertTrue(ValidatorForInput.isValidPhoneNumber("123-456-7890"));
    }

    @Test
    public void phoneValidator_Correct_Example3() {
        assertTrue(ValidatorForInput.isValidPhoneNumber("(123)456-7890"));
    }

    @Test
    public void phoneValidator_Invalid_Example4() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("(1234567890)"));
    }

    @Test
    public void phoneValidator_Invalid_Example5() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("123)4567890"));
    }

    @Test
    public void phoneValidator_Invalid_Example6() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("12345678901"));
    }

    @Test
    public void phoneValidator_Invalid_Example7() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("(1)234567890"));
    }

    @Test
    public void phoneValidator_Invalid_Example8() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("(123)-4567890"));
    }

    @Test
    public void phoneValidator_Invalid_Example9() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("1"));
    }

    @Test
    public void phoneValidator_Invalid_Example10() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("12-3456-7890"));
    }

    @Test
    public void phoneValidator_Invalid_Example11() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("123-4567"));
    }

    @Test
    public void phoneValidator_Invalid_Example12() {
        assertFalse(ValidatorForInput.isValidPhoneNumber("Hello world"));
    }

}
