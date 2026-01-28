package org.example.tests.plugins;


import io.qameta.allure.Allure;
import org.example.core.event.EventBus;
import org.example.core.event.EventListener;
import org.example.core.event.events.ApiRequestFinishedEvent;
import org.example.core.event.events.ApiRequestStartedEvent;
import org.example.core.plugin.PlugIn;
import org.example.model.request.ApiRequest;
import org.example.model.response.ApiResponse;

import java.nio.charset.StandardCharsets;

public class AllureReportingPlugin implements PlugIn {

    @Override
    public void start() {

        EventBus.register(ApiRequestStartedEvent.class, (EventListener<ApiRequestStartedEvent>) event -> {
            ApiRequest req = event.getRequest();

            String reqInfo = """
                    METHOD: %s
                    URL: %s
                    HEADERS: %s
                    BODY: %s
                    """.formatted(
                    req.getMethod(),
                    req.buildFinalUrl(),
                    req.getHeaders(),
                    req.getBody()
            );

            Allure.addAttachment("API Request", "text/plain", reqInfo);
        });

        EventBus.register(ApiRequestFinishedEvent.class, (EventListener<ApiRequestFinishedEvent>) event -> {
            ApiResponse res = event.getResponse();

            String resInfo = """
                    STATUS: %s
                    TIME: %s ms
                    HEADERS: %s
                    BODY: %s
                    """.formatted(
                    res.getStatusCode(),
                    res.getResponseTimeMs(),
                    res.getHeaders(),
                    res.getBody()
            );

            Allure.addAttachment("API Response", "text/plain", resInfo);
        });
    }

    @Override
    public void stop() {
        // nothing needed
    }

    @Override
    public String name() {
        return "Allure Reporting Plugin";
    }
}
