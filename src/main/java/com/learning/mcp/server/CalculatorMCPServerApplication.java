/**
 * MCP Server Application for Calculator Tools
 *
 * This application sets up a Spring Boot server that exposes calculator tools
 * via the Model Context Protocol (MCP) over HTTP using Server-Sent Events (SSE).
 */
package com.learning.mcp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class for the MCP Server.
 * This server exposes calculator tools via the Model Context Protocol (MCP)
 * over HTTP using Server-Sent Events (SSE).
 */
@SpringBootApplication

class CalculatorMCPServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorMCPServerApplication.class, args);
    }

}