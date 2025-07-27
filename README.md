# AI Orchestrator Backend – MVP


This is the minimum viable version of an AI orchestrator backend built with **Java** and **Spring Boot**.  
It processes user-submitted tasks (e.g., summarization) and simulates AI model responses using a modular service structure.

---

## Project Overview

This is a minimal orchestration backend built with **Java and Spring Boot**, designed to receive open-ended user tasks and simulate AI model responses.  
It also marks **my first Spring Boot project**, developed as part of my backend learning journey.

While this version is an MVP, the architecture draws inspiration from broader AGI ideas — such as intent recognition, adaptive decision-making, and dynamic task routing.  
The goal is to build a general-purpose system that understands user intent from free-form input and intelligently selects the best AI tool — moving beyond keyword-based logic.

---
## Features

- Accepts structured task requests via REST API
- DTO-based architecture (`TaskRequest`, `TaskResponse`)
- Spring Boot controller and service layers
- Mock LLM response generation
- Java 21 & Maven project setup

---

## Tech Stack

- Java 21
- Spring Boot 3.5.x
- Maven
- Lombok
- Jakarta Validation
- Postman (for manual API testing)

---

## Folder Structure

```
src/
└── main/
    ├── java/
    │   └── com/aiorchestration/orchestrator/
    │       ├── controller/              # TaskController – API endpoint
    │       ├── dto/                     # Request & Response DTOs
    │       ├── service/                 # Orchestration and mock LLM services
    │       └── OrchestratorApplication.java
    └── resources/
        └── application.properties       # Spring Boot config file
```

---
## How to Run

### Prerequisites
- Java 21
- Maven
- Postman or a similar API testing tool (optional for manual testing)

### Running the App
```bash
# 1. Clone the repository
git clone https://github.com/nehirkilic/ai-orchestrator-backend.git
cd ai-orchestrator-backend

# 2. Build the project
mvn clean install

# 3. Run the application
mvn spring-boot:run


```
> Once the server is running, the API will be accessible at `http://localhost:8000`.  
> You can test the /api/tasks endpoint using Postman or any HTTP client.


---
## API Usage
### Endpoint
`POST /api/tasks`

### Request Body
```json
{
  "taskType": "summarization",
  "input": "Artificial Intelligence is the simulation of human intelligence...",
  "language": "en"
}
```

### Response
```json
{
  "result": "[Mock LLM Response] summarization Artificial Intelligence is the simulation of human intelligence...",
  "taskType": "summarization",
  "language": "en",
  "modelUsed": "mock-llm",
  "status": "success",
  "errorMessage": null
}
```

---

## Future Roadmap

- [ ] Add real LLM API integration (e.g., OpenAI, Claude)
- [ ] Task type–based dynamic routing
- [ ] Prompt templating support
- [ ] Model performance metrics (latency, logs)
- [ ] Authentication & rate limiting

---

## License
Licensed for non-commercial and academic use only.  
© 2025 Nehir Kılıç.  All rights reserved.