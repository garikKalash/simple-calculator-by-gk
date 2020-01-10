package com.calculator.simplecalc.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionValidatorTest {

    private ExpressionValidator expressionValidator =  new ExpressionValidator();

    @Test
    public void isValid() {
        assertFalse(expressionValidator.isValid(""));
        assertFalse(expressionValidator.isValid("    "));
        assertFalse(expressionValidator.isValid(null));
        assertFalse(expressionValidator.isValid("++++"));
        assertFalse(expressionValidator.isValid("****"));
        assertFalse(expressionValidator.isValid("+55"));
        assertFalse(expressionValidator.isValid("*55"));
        assertFalse(expressionValidator.isValid("*5*5"));
        assertFalse(expressionValidator.isValid("5++5"));
        assertFalse(expressionValidator.isValid("5**5"));
        assertFalse(expressionValidator.isValid("5+*5"));
        assertTrue(expressionValidator.isValid("5+6*5"));
    }
}