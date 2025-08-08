# **AI Orchestrator Backend** – v0.2

**Branch:** `feature/intent-detector` — Version `0.2`

This is an upgraded orchestration backend built with **Java** and **Spring Boot**, designed to infer the user’s intent from natural language prompts and return mock responses simulating model behavior.\
This version introduces Hugging Face–powered intent detection, replacing the manual `taskType` logic used in v0.1.

---

## What's New in v0.2

- Introduced zero-shot intent detection using Hugging Face (`xlm-roberta-large-xnli`)
- Removed `taskType` from request body – now inferred dynamically from prompt
- Multilingual prompt understanding (English + Turkish supported, though English yields more accurate intent detection in current model)
- Still returns mock responses – ready for model integration in v0.3
- Removed legacy Javadoc; design details now documented below

---

## How It Works

1. Client sends a `POST` request with a raw natural language input (prompt) and optional `language` field
2. The backend uses Hugging Face's zero-shot classification API to determine the task intent
3. The most probable label is selected from a predefined set of supported task types
4. A mock result is generated based on the detected intent and language

### Supported Task Labels (Configured in `application.yml`)

```yaml
huggingface:
  labels:
    - summarization
    - translation
    - open-dialogue
    - code-generation
    - statistical-analysis
    - data-visualization
    - fact-query
    - math-solution
```

These labels define the scope of intent detection. The system selects the highest scoring label as the task type.

---

## How to Run

### Prerequisites

- Java 21
- Spring Boot 3.5.x
- Maven 3.8+
- Internet access (for calling Hugging Face API)

### Running the Application

```bash
# 1. Clone the repository
git clone https://github.com/nehirkilic/ai-orchestrator-backend.git
cd ai-orchestrator-backend

# 2. Switch to version 0.2
git checkout feature/intent-detector

# 3. Add your Hugging Face token to a .env file or your environment variables
export HUGGINGFACE_API_TOKEN=your_actual_token_here

# 4. Build and run the project
mvn clean install
mvn spring-boot:run
```

> The API will be available at `http://localhost:8080`

---

## Example Usage

### Endpoint

`POST /api/tasks`

### Request Body

```json
{
  "input": "Can you detect the outliers in this data?",
  "language": "en"
}
```

### Response

```json
{
  "result": "[Mock] Simulated response for intent: 'statistical-analysis' in language: en.",
  "taskType": "statistical-analysis",
  "language": "en",
  "modelUsed": "mock-llm",
  "status": "success",
  "errorMessage": null
}
```

---

## Folder Structure

```bash
src/
└── main/
    ├── java/
    │   └── com/
    │       └── aiorchestration/
    │           └── orchestrator/
    │               ├── config/                  # Configuration classes (AppConfig, HuggingFaceConfig)
    │               ├── controller/              # REST API endpoints (TaskController)
    │               ├── dto/                     # Data Transfer Objects (TaskRequest, TaskResponse, HuggingFace DTOs)
    │               └── service/
    │                   └── analyzer/            # Intent detection logic (via Hugging Face)
    └── resources/
        └── application.yml                      # External API config and label definitions
```

---

## Vision & Motivation

This version marks a shift from static, rule-based task classification to intent-aware orchestration.\
By treating user input as a flexible signal rather than a fixed field, this backend becomes a stepping stone toward more adaptive and intelligent task routing logic.

The long-term goal is to dynamically route user prompts to the most suitable AI model — not just based on task type, but also considering context, language, and performance — turning this into a truly intelligent orchestration layer.

While the current response is mock-based, this version lays the groundwork for future LLM integration and more advanced routing strategies.

---

## External Reference

**Model Used:** The system uses the [`joeddav/xlm-roberta-large-xnli`](https://huggingface.co/joeddav/xlm-roberta-large-xnli) model via Hugging Face's Inference API. It is licensed under the [MIT License](https://opensource.org/licenses/MIT), which permits free and unrestricted use.

**Recommended Resource:** For Turkish-speaking learners exploring Hugging Face for the first time, [M. Murat Arat](https://github.com/mmuratarat)'s article — [“Hugging Face’e Giriş”](https://mmuratarat.github.io/turkish/2023-08-16/huggingface_intro) — provides an excellent introduction to Hugging Face.

Since this was my first time using Hugging Face in a project, I found this article particularly helpful in understanding the fundamentals and getting started with its API and pipeline system.

---

## Roadmap

- **v0.3** – Model selector for routing based on intent and language
- **v0.4** – Real LLM integration
- **v0.5** – Trust scores, fallback mechanisms, and evaluation layer

---

## Compatibility Note

> This project requires **Java 21** and **Spring Boot 3.5.x** due to the use of modern language features and configuration support. Make sure your development environment meets these requirements.

---

## License

Licensed for non-commercial and academic use only.\
© 2025 Nehir Kılıç. All rights reserved.

 
