package com.aiorchestration.orchestrator.dto;

import java.util.List;

public record HuggingFaceResponseDTO(
        String sequence,
        List<String> labels,
        List<Double> scores
) {}
