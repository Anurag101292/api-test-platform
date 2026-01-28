package org.example.core.event.events;

import org.example.core.event.Event;
import org.example.model.response.ApiResponse;
import org.example.model.request.ApiRequest;

public class ApiRequestFinishedEvent  implements Event {

    private final ApiRequest request;
    private final ApiResponse response;

    public ApiRequestFinishedEvent(ApiRequest request, ApiResponse response) {
        this.request = request;
        this.response = response;
    }

    public ApiRequest getRequest() {
        return request;
    }

    public ApiResponse getResponse() {
        return response;
    }
}
