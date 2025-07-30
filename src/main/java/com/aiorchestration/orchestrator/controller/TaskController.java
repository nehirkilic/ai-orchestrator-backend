package com.aiorchestration.orchestrator.controller;

import com.aiorchestration.orchestrator.dto.TaskRequest;
import com.aiorchestration.orchestrator.dto.TaskResponse;
import com.aiorchestration.orchestrator.service.TaskOrchestrationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskOrchestrationService service;

    public TaskController(TaskOrchestrationService service) {
        this.service = service;
    }

    @PostMapping
    public TaskResponse handleTask(@Valid @RequestBody TaskRequest request) {
        return service.processTask(request);
    }
}