/*
 * Copyright 2024-2025 Embabel Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

//    @Bean
//    public ToolCallbackProvider quoteProvider(CalculatorService calculatorService) {
//        return MethodToolCallbackProvider.builder()
//                .toolObjects(calculatorService)
//                .build();
//    }

}