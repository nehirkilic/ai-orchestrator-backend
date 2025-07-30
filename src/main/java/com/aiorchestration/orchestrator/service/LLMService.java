package com.aiorchestration.orchestrator.service;

import org.springframework.stereotype.Service;

@Service
public class LLMService {

    public String generateResponse(String taskType, String language) {
        return "[Mock] Simulated response for intent: '" + taskType + "' in language: " + language + ".";
    }
}
