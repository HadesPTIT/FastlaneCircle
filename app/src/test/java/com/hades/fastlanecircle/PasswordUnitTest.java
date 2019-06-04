package com.hades.fastlanecircle;

import com.hades.fastlanecircle.utils.ValidatorForInput;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordUnitTest {

    /**
     * Correct Input
     */
    @Test
    public void passValidator_CorrectPassSimple_ReturnsTrue() {
        assertTrue(ValidatorForInput.isValidPassword("Aa@123456"));
    }

    @Test
    public void passValidator_InvalidPass_Case1() {
        assertFalse(ValidatorForInput.isValidPassword(null));
    }

    @Test
    public void passValidator_InvalidPass_Case2() {
        assertFalse(ValidatorForInput.isValidPassword("123456"));
    }

    @Test
    public void passValidator_InvalidPass_Case3() {
        assertFalse(ValidatorForInput.isValidPassword("1111222233334444"));
    }


}
