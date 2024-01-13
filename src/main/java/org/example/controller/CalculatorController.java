package org.example.controller;

import org.example.exception.DivByZeroException;
import org.example.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор !";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2", required = false) Integer b) {
        return calculate(a, b, "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a,
                        @RequestParam(value = "num2", required = false) Integer b) {
        return calculate(a, b, "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a,
                           @RequestParam(value = "num2", required = false) Integer b) {
        return calculate(a, b, "*");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a,
                         @RequestParam(value = "num2", required = false) Integer b) {
        return calculate(a, b, "/");
    }

    private String calculate(Integer a, Integer b, String operation) {
        if (a == null || b == null) {
            return "Какой-то из параметров не передан!";
        }

        int result = switch (operation) {
            case "-" -> calculatorService.minus(a, b);
            case "*" -> calculatorService.multiply(a, b);
            case "/" -> calculatorService.divide(a, b);
            default -> calculatorService.plus(a, b);
        };
        return "%d %s %d = %d".formatted(a, operation, b, result);
    }

    @ExceptionHandler(DivByZeroException.class)
    public String handleDivByZeroException() {
        return "На ноль делить нельзя!";
    }
}