package org.example.core.event.events;


import org.example.core.event.Event;
import org.example.model.request.ApiRequest;

public class ApiRequestStartedEvent implements Event {
    private final ApiRequest request;

    public ApiRequestStartedEvent(ApiRequest request) {
        this.request = request;
    }

    public ApiRequest getRequest() {
        return request;
    }
}
