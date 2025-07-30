package com.aiorchestration.orchestrator.service.analyzer;

import com.aiorchestration.orchestrator.config.HuggingFaceConfig;
import com.aiorchestration.orchestrator.dto.HuggingFaceRequestDTO;
import com.aiorchestration.orchestrator.dto.HuggingFaceResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HuggingFacePromptAnalyzerService implements PromptAnalyzerService {

    private static final Logger logger = LoggerFactory.getLogger(HuggingFacePromptAnalyzerService.class);

    private final HuggingFaceConfig config;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public HuggingFacePromptAnalyzerService(HuggingFaceConfig config,
                                            RestTemplate restTemplate,
                                            ObjectMapper objectMapper) {
        this.config = config;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public String detectIntent(String prompt) {
        HuggingFaceRequestDTO request = new HuggingFaceRequestDTO(prompt, config.labels());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(config.api().token());

        HttpEntity<HuggingFaceRequestDTO> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(config.api().url(), entity, String.class);

            logger.debug("Hugging Face raw response: {}", response.getBody());

            HuggingFaceResponseDTO result = objectMapper.readValue(response.getBody(), HuggingFaceResponseDTO.class);

            List<String> labels = result.labels();
            List<Double> scores = result.scores();

            if (labels == null || scores == null || labels.size() != scores.size()) {
                logger.warn("Received incomplete or mismatched response from Hugging Face");
                return "unknown";
            }

            int maxIndex = 0;
            double maxScore = 0;
            for (int i = 0; i < scores.size(); i++) {
                if (scores.get(i) > maxScore) {
                    maxScore = scores.get(i);
                    maxIndex = i;
                }
            }

            String intent = labels.get(maxIndex);
            logger.info("Detected intent: {} (confidence: {})", intent, maxScore);
            return intent;

        } catch (Exception e) {
            logger.error("Hugging Face request failed: {}", e.getMessage(), e);
            return "unknown";
        }
    }
}
