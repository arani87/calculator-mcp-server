package com.learning.mcp.server.calculator.service;

import com.learning.mcp.server.calculator.model.CalculationResult;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import org.springaicommunity.mcp.annotation.McpProgressToken;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

/**
 * Calculator service that exposes arithmetic operations as MCP tools.
 * These tools can be discovered and invoked by any MCP-compatible client.
 */
@Service
public class CalculatorService {

    /**
     * Performs basic arithmetic operations.
     * This method is exposed as an MCP tool that can be called remotely.
     *
     * @param operation The operation to perform (add, subtract, multiply, divide)
     * @param operand1  The first operand
     * @param operand2  The second operand
     * @return A Mono containing the CalculationResult
     */
    @McpTool(
            name = "calculate",
            description = "Perform basic arithmetic operations (add, subtract, multiply, divide) on two numbers"
    )
    public CalculationResult calculate(
            McpSyncServerExchange exchange,
            @McpToolParam(description = "The arithmetic operation to perform: add, subtract, multiply, or divide")
            String operation,
            @McpToolParam(description = "The first number")
            double operand1,
            @McpToolParam(description = "The second number")
            double operand2,
            @McpProgressToken String progressToken
    ) {
// 0% progress
        exchange.progressNotification(new McpSchema.ProgressNotification(progressToken, 0.0, 1.0, "Calculation started"));
        double result = switch (operation.toLowerCase()) {
            case "add" -> operand1 + operand2;
            case "subtract" -> operand1 - operand2;
            case "multiply" -> operand1 * operand2;
            case "divide" -> {
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException(
                    "Invalid operation: " + operation + ". Supported operations are: add, subtract, multiply, divide"
            );
        };
        try {
            Thread.sleep(500); // 500ms delay to simulate processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        exchange.progressNotification(new McpSchema.ProgressNotification(progressToken, 1.0, 1.0, "Calculation Completed"));

        return new CalculationResult(operation, operand1, operand2, result);

    }

}