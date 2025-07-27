package com.aiorchestration.orchestrator.service;

import org.springframework.stereotype.Service;

/**
 * Mock service that simulates LLM (Large Language Model) output generation.
 * <p>
 * This version does not call a real API, but returns a fixed mock response.
 * Will be replaced with real LLM integration in future versions.
 *
 * @author Nehir
 * @version 0.1-MVP
 */
@Service
public class LLMService {

    /**
     * Generates a mock response based on task type and input.
     *
     * @param prompt   the raw user input or request content
     * @param taskType the task type to simulate (e.g., summarization)
     * @param language the language of the input
     * @return a fixed dummy string representing LLM output
     */
    public String generateResponse(String prompt, String taskType, String language) {
        return "[Mock LLM Response] " + taskType + " " + prompt;
    }
}
