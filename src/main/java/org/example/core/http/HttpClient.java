package org.example.core.http;

import org.example.model.request.ApiRequest;
import org.example.model.response.ApiResponse;

public interface HttpClient {
    ApiResponse execute(ApiRequest request);
}
