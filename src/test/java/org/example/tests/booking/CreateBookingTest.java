package org.example.tests.booking;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.example.base.BaseTest;
import org.example.core.http.impl.RestAssuredHttpClient;
import org.example.model.response.ApiResponse;
import org.example.service.booking.BookingService;
import org.example.service.booking.impl.BookingServiceImpl;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;

import java.util.Map;

public class CreateBookingTest extends BaseTest {

    @Epic("Booking creation")
    @Feature("Regression")
    @Description("Utility  Regression  test")
    @Test
    public void shouldCreateBookingSuccessfully() {

        BookingService bookingService =
                new BookingServiceImpl(new RestAssuredHttpClient());

        Map<String, Object> body = Map.of(
                "firstname", "John",
                "lastname", "Smith",
                "totalprice", 123,
                "depositpaid", true,
                "bookingdates", Map.of(
                        "checkin", "2024-01-01",
                        "checkout", "2024-01-05"
                ),
                "additionalneeds", "Breakfast"
        );

        ApiResponse response = bookingService.createBooking(body);

        // Assertions
        assertThat(response.getStatusCode(), is(200));
        assertThat(response.getBody(), containsString("bookingid"));

        JsonPath json = new JsonPath(response.getBody());
        assertThat(json.get("bookingid"), notNullValue());
        assertThat(json.getString("booking.firstname"), equalTo("John"));
    }
}
