package org.example.tests.plugins;

import org.example.core.event.EventBus;
import org.example.core.event.EventListener;
import org.example.core.event.events.ApiRequestFinishedEvent;
import org.example.core.event.events.ApiRequestStartedEvent;
import org.example.core.plugin.PlugIn;
import org.example.model.request.ApiRequest;
import org.example.model.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiLoggingPlugin implements PlugIn {

    private static final Logger log = LoggerFactory.getLogger(ApiLoggingPlugin.class);

    @Override
    public void start() {

        EventBus.register(ApiRequestStartedEvent.class, (EventListener<ApiRequestStartedEvent>) event -> {
            ApiRequest r = event.getRequest();
            log.info("➡️ API Request: {} {}", r.getMethod(), r.buildFinalUrl());
        });

        EventBus.register(ApiRequestFinishedEvent.class, (EventListener<ApiRequestFinishedEvent>) event -> {
            ApiResponse res = event.getResponse();
            log.info("⬅️ API Response: status={} time={}ms",
                    res.getStatusCode(),
                    res.getResponseTimeMs());
        });

        log.info("✅ Plugin started: {}", name());
    }

    @Override
    public void stop() {
        // Optional: cleanup, unregister listeners if you want
        log.info("🛑 Plugin stopped: {}", name());
    }

    @Override
    public String name() {
        return "API Logging Plugin";
    }
}
