package com.aiorchestration.orchestrator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "huggingface")
public record HuggingFaceConfig(
        Api api,
        List<String> labels
) {
    public record Api(String url, String token) {}
}
