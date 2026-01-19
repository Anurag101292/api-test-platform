package org.example.model.response;
import java.util.Map;


public class ApiResponse {

    private int statusCode;
    private String body;
    private Map<String, String> headers;
    private long responseTimeMs;

    public int getStatusCode() { return statusCode; }
    public String getBody() { return body; }
    public Map<String, String> getHeaders() { return headers; }
    public long getResponseTimeMs() { return responseTimeMs; }

    public ApiResponse setStatusCode(int statusCode) {
        this.statusCode = statusCode; return this;
    }

    public ApiResponse setBody(String body) {
        this.body = body; return this;
    }

    public ApiResponse setHeaders(Map<String, String> headers) {
        this.headers = headers; return this;
    }

    public ApiResponse setResponseTimeMs(long responseTimeMs) {
        this.responseTimeMs = responseTimeMs; return this;
    }
}

