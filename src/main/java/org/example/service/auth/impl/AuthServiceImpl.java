package org.example.service.auth.impl;

import io.restassured.path.json.JsonPath;
import org.example.core.config.ConfigManager;
import org.example.model.internal.HttpMethod;
import org.example.model.request.ApiRequest;
import org.example.model.response.ApiResponse;
import org.example.service.auth.AuthService;
import org.example.core.http.HttpClient;

import java.util.Map;

public class AuthServiceImpl implements AuthService {

    private final HttpClient httpClient;

    public AuthServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public String createToken() {

        Map<String, String> body = Map.of(
                "username", "admin",
                "password", "password123"
        );

        ApiRequest request = new ApiRequest()
                .setBaseUrl(ConfigManager.getString("qa.baseUrl"))
                .setPath("/auth")
                .setMethod(HttpMethod.POST)
                .addHeader("Content-Type", "application/json")
                .setBody(body);

        ApiResponse response = httpClient.execute(request);

        JsonPath json = new JsonPath(response.getBody());
        return json.getString("token");
    }
}
