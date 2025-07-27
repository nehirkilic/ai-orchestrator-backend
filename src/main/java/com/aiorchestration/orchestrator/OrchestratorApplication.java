package com.aiorchestration.orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the AI Task Orchestration application.
 * <p>
 * Boots the Spring context and initializes all components.
 *
 * @author Nehir
 * @version 0.1-MVP
 */
@SpringBootApplication
public class OrchestratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrchestratorApplication.class, args);
    }

}