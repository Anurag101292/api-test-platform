package org.example.model.request;

import org.example.model.internal.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {

    private String baseUrl;
    private String path;
    private String url; // optional: full URL override

    private HttpMethod method;

    private Map<String, String> headers = new HashMap<>();
    private Map<String, Object> queryParams = new HashMap<>();

    private Object body;

    // ---------------- Getters ----------------

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPath() {
        return path;
    }

    public String getUrl() {
        return url;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }

    public Object getBody() {
        return body;
    }

    // ---------------- Setters (Fluent) ----------------

    public ApiRequest setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public ApiRequest setPath(String path) {
        this.path = path;
        return this;
    }

    public ApiRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public ApiRequest setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public ApiRequest addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public ApiRequest setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public ApiRequest addQueryParam(String key, Object value) {
        this.queryParams.put(key, value);
        return this;
    }

    public ApiRequest setQueryParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
        return this;
    }

    public ApiRequest setBody(Object body) {
        this.body = body;
        return this;
    }

    // ---------------- Convenience ----------------

    public String buildFinalUrl() {
        if (url != null && !url.isBlank()) {
            return url;
        }
        if (baseUrl == null) {
            throw new IllegalStateException("BaseUrl is not set");
        }
        if (path == null) {
            return baseUrl;
        }
        return baseUrl + path;
    }
}
