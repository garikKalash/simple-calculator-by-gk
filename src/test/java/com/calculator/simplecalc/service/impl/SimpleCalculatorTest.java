package com.calculator.simplecalc.service.impl;

import com.calculator.simplecalc.validator.ExpressionValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleCalculatorTest {

    private static String VALID_EXPRESSION = "2 * 3 + 5 + 6*7*1*3 +1";

    
    static SimpleCalculator simpleCalculator;

    @BeforeClass
    public static void init(){
        ExpressionValidator expressionValidator = mock(ExpressionValidator.class);
        when(expressionValidator.isValid("")).thenReturn(false);
        when(expressionValidator.isValid("    ")).thenReturn(false);
        when(expressionValidator.isValid(null)).thenReturn(false);
        when(expressionValidator.isValid("++++")).thenReturn(false);
        when(expressionValidator.isValid("****")).thenReturn(false);
        when(expressionValidator.isValid("+55")).thenReturn(false);
        when(expressionValidator.isValid("*55")).thenReturn(false);
        when(expressionValidator.isValid("*5*5")).thenReturn(false);
        when(expressionValidator.isValid("5++5")).thenReturn(false);
        when(expressionValidator.isValid("5**5")).thenReturn(false);
        when(expressionValidator.isValid("5+*5")).thenReturn(false);
        when(expressionValidator.isValid(VALID_EXPRESSION)).thenReturn(true);

        simpleCalculator = new SimpleCalculator(expressionValidator);
    }
    
    @Test
    public void evaluate() {
        assertEquals(simpleCalculator.evaluate(VALID_EXPRESSION), Integer.valueOf(138));
    }
}