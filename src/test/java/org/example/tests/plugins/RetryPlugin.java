package org.example.tests.plugins;

import org.example.core.event.EventBus;
import org.example.core.event.EventListener;
import org.example.core.event.events.ApiRequestFinishedEvent;
import org.example.core.plugin.PlugIn;
import org.example.model.request.ApiRequest;
import org.example.model.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetryPlugin implements PlugIn {

    private static final Logger log = LoggerFactory.getLogger(RetryPlugin.class);

    private final int maxRetries;

    public RetryPlugin(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public void start() {

        EventBus.register(ApiRequestFinishedEvent.class, (EventListener<ApiRequestFinishedEvent>) event -> {

            ApiResponse response = event.getResponse();

            // Retry only for server errors or timeouts
            if (response.getStatusCode() >= 500) {
                log.warn("⚠️ API failed with status {}. Retry logic should trigger here.", response.getStatusCode());

                // NOTE: In real system we would re-execute request here.
                // For now, we just demonstrate architecture.
            }
        });

        log.info("✅ Plugin started: {} (maxRetries={})", name(), maxRetries);
    }

    @Override
    public void stop() {
        log.info("🛑 Plugin stopped: {}", name());
    }

    @Override
    public String name() {
        return "Retry Plugin";
    }
}
