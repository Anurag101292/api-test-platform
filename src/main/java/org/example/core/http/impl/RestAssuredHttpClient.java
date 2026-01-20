package org.example.core.http.impl;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.core.http.HttpClient;
import org.example.model.request.ApiRequest;
import org.example.model.response.ApiResponse;
import java.util.stream.Collectors;
import io.restassured.http.Header;



public class RestAssuredHttpClient implements HttpClient {

    @Override
    public ApiResponse execute(ApiRequest request) {

        RequestSpecification spec = RestAssured.given();

        // headers
        if (request.getHeaders() != null) {
            spec.headers(request.getHeaders());
        }

        // query params
        if (request.getQueryParams() != null) {
            spec.queryParams(request.getQueryParams());
        }

        // body
        if (request.getBody() != null) {
            spec.body(request.getBody());
        }

        Response response;

        String url = request.getBaseUrl() + request.getPath();

        switch (request.getMethod()) {
            case GET -> response = spec.when().get(url);
            case POST -> response = spec.when().post(url);
            case PUT -> response = spec.when().put(url);
            case DELETE -> response = spec.when().delete(url);
            case PATCH -> response = spec.when().patch(url);
            default -> throw new IllegalArgumentException("Unsupported HTTP method");
        }

        // build headers map
        var headersMap = response.getHeaders().asList().stream()
                .collect(Collectors.toMap(
                        h -> h.getName(),
                        h -> h.getValue(),
                        (a, b) -> b
                ));

        return new ApiResponse()
                .setStatusCode(response.getStatusCode())
                .setBody(response.getBody().asString())
                .setHeaders(headersMap)
                .setResponseTimeMs(response.getTime());
    }
}
