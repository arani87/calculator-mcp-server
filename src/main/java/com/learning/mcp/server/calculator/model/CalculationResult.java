package com.learning.mcp.server.calculator.model;

/**
 * Result object for calculation operations.
 */
public record CalculationResult(
        String operation,
        double operand1,
        double operand2,
        double result,
        String expression
) {
    public CalculationResult(String operation, double operand1, double operand2, double result) {
        this(
                operation,
                operand1,
                operand2,
                result,
                String.format("%s %s %s = %s", operand1, getOperatorSymbol(operation), operand2, result)
        );
    }

    private static String getOperatorSymbol(String operation) {
        return switch (operation.toLowerCase()) {
            case "add" -> "+";
            case "subtract" -> "-";
            case "multiply" -> "×";
            case "divide" -> "÷";
            default -> operation;
        };
    }
}
