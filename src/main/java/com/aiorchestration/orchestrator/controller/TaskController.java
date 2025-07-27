package com.aiorchestration.orchestrator.controller;

import com.aiorchestration.orchestrator.dto.TaskRequest;
import com.aiorchestration.orchestrator.dto.TaskResponse;
import com.aiorchestration.orchestrator.service.TaskOrchestrationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller that handles incoming task requests from clients.
 * <p>
 * Accepts task input in JSON format and returns AI-generated responses.
 * Delegates processing to the TaskOrchestrationService.
 * <p>
 * Example endpoint: POST /api/tasks
 *
 * @author Nehir
 * @version 0.1-MVP
 */
@RestController
public class TaskController {

    private final TaskOrchestrationService service;

    public TaskController(TaskOrchestrationService service) {
        this.service = service;
    }

    /**
     * Receives a task request and returns the processed response.
     *
     * @param request the task input submitted by the client
     * @return the AI-generated response
     */
    @PostMapping("/api/tasks")
    public TaskResponse handleTask(@Valid @RequestBody TaskRequest request) {
        return service.processTask(request);
    }
}