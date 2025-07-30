package com.aiorchestration.orchestrator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {
    private String result;
    private String taskType;
    private String language;
    private String modelUsed;
    private String status;
    private String errorMessage;
}