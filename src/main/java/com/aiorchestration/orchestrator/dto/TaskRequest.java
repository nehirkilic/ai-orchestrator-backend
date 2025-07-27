package com.aiorchestration.orchestrator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO representing a user-submitted task request for the orchestration engine.
 * <p>
 * Contains the core data used to:
 * </p>
 * <p>
 * Identify the nature of the task (e.g., summarization, code analysis)
 * Interpret the raw input (prompt or source data)
 * Adjust behavior based on language context (e.g., prompt templates)
 * <p>
 * <p>
 * Example JSON:
 * <p>
 * {
 * "taskType": "summarization",
 * "input": "Please summarize the following paragraph...",
 * "language": "en"
 * }
 *
 * @author Nehir
 * @version 0.1-MVP
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequest {

    /**
     * Type or category of the task to be performed.
     * Used for routing and prompt selection.
     * Examples: "summarization", "code-generation", "translation"
     */
    @NotBlank(message = "Task type must not be blank.")
    private String taskType;

    /**
     * The user's raw input — can be a prompt, code snippet, or data.
     */
    @NotBlank(message = "Input must not be blank.")
    private String input;

    /**
     * Language code of the input (e.g., "en", "tr").
     * Defaults to "en" if not provided.
     */
    private String language = "en";
}