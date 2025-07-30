package com.aiorchestration.orchestrator.service;

import com.aiorchestration.orchestrator.dto.TaskRequest;
import com.aiorchestration.orchestrator.dto.TaskResponse;
import com.aiorchestration.orchestrator.service.analyzer.PromptAnalyzerService;
import org.springframework.stereotype.Service;

@Service
public class TaskOrchestrationService {

    private final LLMService llmService;
    private final PromptAnalyzerService promptAnalyzerService;

    public TaskOrchestrationService(LLMService llmService,
                                    PromptAnalyzerService promptAnalyzerService) {
        this.llmService = llmService;
        this.promptAnalyzerService = promptAnalyzerService;
    }

    public TaskResponse processTask(TaskRequest taskRequest) {
        String prompt = taskRequest.getInput();
        String language = taskRequest.getLanguage();


        String intent = promptAnalyzerService.detectIntent(prompt);

        String result = llmService.generateResponse(intent, language);

        return TaskResponse.builder()
                .result(result)
                .taskType(intent)
                .language(language)
                .modelUsed("mock-llm")
                .status("success")
                .errorMessage(null)
                .build();
    }
}
