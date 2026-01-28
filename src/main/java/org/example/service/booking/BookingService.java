package org.example.service.booking;

import org.example.model.response.ApiResponse;

import java.util.Map;

public interface BookingService {

    ApiResponse createBooking(Object payload);

    ApiResponse getBooking(int bookingId);

    ApiResponse deleteBooking(int bookingId, String token);

    ApiResponse getBookingIds(Map<String, Object> queryParams);

    ApiResponse updateBooking(int bookingId, Object payload, String token);

    ApiResponse partialUpdateBooking(int bookingId, Object payload, String token);

}
