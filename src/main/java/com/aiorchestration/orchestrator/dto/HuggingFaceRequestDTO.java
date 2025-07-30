package com.aiorchestration.orchestrator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuggingFaceRequestDTO {

    private String inputs;
    private Parameters parameters;

    public HuggingFaceRequestDTO(String inputs, List<String> candidateLabels) {
        this.inputs = inputs;
        this.parameters = new Parameters(candidateLabels);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Parameters {

        @JsonProperty("candidate_labels")
        private List<String> candidateLabels;

        @JsonProperty("multi_label")
        private boolean multiLabel = false;

        public Parameters(List<String> candidateLabels) {
            this.candidateLabels = candidateLabels;
            this.multiLabel = false; // default
        }

    }
}
