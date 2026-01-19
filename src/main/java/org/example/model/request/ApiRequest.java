package org.example.model.request;
import org.example.model.internal.HttpMethod;

import java.util.HashMap;
import java.util.Map;


public class ApiRequest {

    private String url;
    private HttpMethod method;
    private Map<String, String> headers = new HashMap<>();
    private Object body;
    private Map<String, Object> queryParams = new HashMap<>();

    public String getUrl() { return url; }
    public HttpMethod getMethod() { return method; }
    public Map<String, String> getHeaders() { return headers; }
    public Object getBody() { return body; }
    public Map<String, Object> getQueryParams() { return queryParams; }

    public ApiRequest setUrl(String url) {
        this.url = url; return this;
    }

    public ApiRequest setMethod(HttpMethod method) {
        this.method = method; return this;
    }

    public ApiRequest addHeader(String key, String value) {
        headers.put(key, value); return this;
    }

    public ApiRequest setBody(Object body) {
        this.body = body; return this;
    }

    public ApiRequest addQueryParam(String key, Object value) {
        queryParams.put(key, value); return this;
    }
}
