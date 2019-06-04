package com.hades.fastlanecircle;

import com.hades.fastlanecircle.utils.ValidatorForInput;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailUnitTest {

    /**
     * Correct Input
     */
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(ValidatorForInput.isValidEmail("name@email.com"));
    }

    /**
     * Email with subdomain
     */
    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(ValidatorForInput.isValidEmail("name@email.co.uk"));
    }

    /**
     * With extra characters
     */
    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(ValidatorForInput.isValidEmail("name@email..com"));
    }

    /**
     * With no user name
     */
    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(ValidatorForInput.isValidEmail("@email.com"));
    }

    /**
     * Empty Input
     */
    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(ValidatorForInput.isValidEmail(""));
    }

    /**
     * Null value check
     */
    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(ValidatorForInput.isValidEmail(null));
    }

}
