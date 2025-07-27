package com.aiorchestration.orchestrator.service;

import com.aiorchestration.orchestrator.dto.TaskRequest;
import com.aiorchestration.orchestrator.dto.TaskResponse;
import org.springframework.stereotype.Service;

/**
 * Service layer responsible for orchestrating task processing logic.
 * <p>
 * Receives task requests and coordinates response generation
 * through the underlying LLMService.
 * <p>
 * This version returns mock responses only. Real orchestration
 * logic will be introduced in later versions.
 *
 * @author Nehir
 * @version 0.1-MVP
 */
@Service
public class TaskOrchestrationService {

    public final LLMService llmService;

    public TaskOrchestrationService(LLMService llmService) {
        this.llmService = llmService;
    }

    /**
     * Processes the incoming task request and generates a response.
     *
     * @param taskRequest the incoming user request with input and metadata
     * @return a mock response simulating LLM output
     */
    public TaskResponse processTask(TaskRequest taskRequest) {
        String result = llmService.generateResponse(
                taskRequest.getInput(),
                taskRequest.getTaskType(),
                taskRequest.getLanguage()
        );

        return TaskResponse.builder()
                .result(result)
                .taskType(taskRequest.getTaskType())
                .language(taskRequest.getLanguage())
                .modelUsed("mock-llm")
                .status("success")
                .errorMessage(null)
                .build();
    }
}