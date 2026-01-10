# MCP Server

This project is a Java-based MCP (Message Communication Protocol) server implemented using Spring Boot and Gradle. 
The server is designed to handle MCP protocol messages, providing a robust and extensible backend for MCP-compliant clients.

## Features

- **Spring Boot**: Rapid development and easy configuration.
- **MCP Protocol Support**: Handles message parsing, validation, and response.
- **Extensible Architecture**: Easily add new message types and handlers.
- **Gradle Build**: Simple dependency management and build process.

## Getting Started

### Prerequisites

- Java 21 or higher
- Gradle 8.x or higher
- Node.js (for MCP Inspector)

### Build and Run

```bash
./gradlew build
./gradlew bootRun
npx @modelcontextprotocol/inspector
```
The npx command runs the MCP Inspector, a tool for inspecting and debugging MCP messages.
Go to the URL provided in the console to access the MCP Inspector interface.
Use Streamable HTTP as the transport layer to connect to the MCP server.

### Configuration to connect with Claude desktop
To connect the MCP server with Claude desktop, follow these steps:
1. Open Claude desktop application.
2. Navigate to the settings or preferences section.
3. Locate the Developer or Advanced settings.
4. Click on "Edit Config"
5. This opens the configuration file in your default text editor.
6. Add the following configuration to enable MCP connection:
```json
{
  "mcpServers": {
    "calculator": {
      "command": "npx",
      "args": [
        "-y",
        "mcp-remote",
        "http://localhost:8080/mcp"
      ]
    }
  }
}
```