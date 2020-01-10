package com.calculator.simplecalc.controller;

import com.calculator.simplecalc.service.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

     @Autowired
     private Evaluator simpleCalculator;

     @GetMapping(value = "/api/agritaskcalculator/result/{expression}")
     public ResponseEntity<Integer> getResult(@PathVariable String expression){
          return new ResponseEntity<>(simpleCalculator.evaluate(expression), HttpStatus.OK);
     }

}
