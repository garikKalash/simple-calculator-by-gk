package com.agritaskcalculator.agritaskcalc.validator;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ExpressionValidator {

    public boolean isValid(String expression){
        if(expression == null || expression.isEmpty()) return false;

        expression = clearWhiteSpaces(expression);

        String[] splitPartsByPlus = expression.split("\\+");
        if(splitPartsByPlus.length == 0 || Arrays.asList(splitPartsByPlus).contains("")) return false;

        for(String mult : splitPartsByPlus){
            String[] splitPartsByMult = mult.split("\\*");
            if(splitPartsByMult.length == 0 || Arrays.asList(splitPartsByMult).contains("")) return false;
        }

        return true;
    }

    private String clearWhiteSpaces(String expression){
        return expression.replaceAll(" ", "");
    }
}
