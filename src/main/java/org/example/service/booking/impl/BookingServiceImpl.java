package org.example.service.booking.impl;

import org.example.core.config.ConfigManager;
import org.example.core.http.HttpClient;
import org.example.model.internal.HttpMethod;
import org.example.model.request.ApiRequest;
import org.example.model.response.ApiResponse;
import org.example.service.booking.BookingService;

import java.util.Map;

public class BookingServiceImpl implements BookingService {

    private final HttpClient httpClient;

    public BookingServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public ApiResponse createBooking(Object payload) {

        ApiRequest request = new ApiRequest()
                .setBaseUrl(ConfigManager.getString("qa.baseUrl"))
                .setPath("/booking")
                .setMethod(HttpMethod.POST)
                .addHeader("Content-Type", "application/json")
                .setBody(payload);

        return httpClient.execute(request);
    }

    @Override
    public ApiResponse getBooking(int bookingId) {

        ApiRequest request = new ApiRequest()
                .setBaseUrl(ConfigManager.getString("qa.baseUrl"))
                .setPath("/booking/" + bookingId)
                .setMethod(HttpMethod.GET);

        return httpClient.execute(request);
    }

    public ApiResponse getBookingIds(Map<String, Object> queryParams) {

        ApiRequest request = new ApiRequest()
                .setBaseUrl(ConfigManager.getString("qa.baseUrl"))
                .setPath("/booking")
                .setMethod(HttpMethod.GET)
                .setQueryParams(queryParams);

        return httpClient.execute(request);
    }

    public ApiResponse updateBooking(int bookingId, Object payload, String token) {

        ApiRequest request = new ApiRequest()
                .setBaseUrl(ConfigManager.getString("qa.baseUrl"))
                .setPath("/booking/" + bookingId)
                .setMethod(HttpMethod.PUT)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", "token=" + token)
                .setBody(payload);

        return httpClient.execute(request);
    }

    public ApiResponse partialUpdateBooking(int bookingId, Object payload, String token) {

        ApiRequest request = new ApiRequest()
                .setBaseUrl(ConfigManager.getString("qa.baseUrl"))
                .setPath("/booking/" + bookingId)
                .setMethod(HttpMethod.PATCH)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", "token=" + token)
                .setBody(payload);

        return httpClient.execute(request);
    }

    @Override
    public ApiResponse deleteBooking(int bookingId, String token) {

        ApiRequest request = new ApiRequest()
                .setBaseUrl(ConfigManager.getString("qa.baseUrl"))
                .setPath("/booking/" + bookingId)
                .setMethod(HttpMethod.DELETE)
                .addHeader("Cookie", "token=" + token);

        return httpClient.execute(request);
    }
}
