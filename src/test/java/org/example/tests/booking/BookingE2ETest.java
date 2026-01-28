package org.example.tests.booking;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.path.json.JsonPath;
import org.example.base.BaseTest;
import org.example.core.http.impl.RestAssuredHttpClient;
import org.example.service.auth.AuthService;
import org.example.service.auth.impl.AuthServiceImpl;
import org.example.service.booking.BookingService;
import org.example.service.booking.impl.BookingServiceImpl;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BookingE2ETest extends BaseTest {

    @Epic("Smoke")
    @Feature("Sanity")
    @Description("Utility sanity test")
    @Test
    public void fullBookingFlowTest() {

        var client = new RestAssuredHttpClient();
        BookingService bookingService = new BookingServiceImpl(client);
        AuthService authService = new AuthServiceImpl(client);

        // 1️⃣ Create Booking
        Map<String, Object> createPayload = Map.of(
                "firstname", "John",
                "lastname", "Doe",
                "totalprice", 100,
                "depositpaid", true,
                "bookingdates", Map.of(
                        "checkin", "2024-01-01",
                        "checkout", "2024-01-10"
                ),
                "additionalneeds", "Breakfast"
        );

        var createResponse = bookingService.createBooking(createPayload);
        assertThat(createResponse.getStatusCode(), is(200));

        JsonPath createJson = new JsonPath(createResponse.getBody());
        int bookingId = createJson.getInt("bookingid");

        // 2️⃣ Get Booking
        var getResponse = bookingService.getBooking(bookingId);
        assertThat(getResponse.getStatusCode(), is(200));

        // 3️⃣ Get Token
        String token = authService.createToken();
        assertThat(token, notNullValue());

        // 4️⃣ Update Booking (PUT)
        Map<String, Object> updatePayload = Map.of(
                "firstname", "Jane",
                "lastname", "Doe",
                "totalprice", 200,
                "depositpaid", true,
                "bookingdates", Map.of(
                        "checkin", "2024-02-01",
                        "checkout", "2024-02-10"
                ),
                "additionalneeds", "Lunch"
        );

        var updateResponse = bookingService.updateBooking(bookingId, updatePayload, token);
        assertThat(updateResponse.getStatusCode(), is(200));

        // 5️⃣ Partial Update (PATCH)
        Map<String, Object> patchPayload = Map.of(
                "firstname", "PatchedName"
        );

        var patchResponse = bookingService.partialUpdateBooking(bookingId, patchPayload, token);
        assertThat(patchResponse.getStatusCode(), is(200));

        // 6️⃣ Delete Booking
        var deleteResponse = bookingService.deleteBooking(bookingId, token);
        assertThat(deleteResponse.getStatusCode(), anyOf(is(200), is(201)));

        // 7️⃣ Verify Deleted
        var getAfterDelete = bookingService.getBooking(bookingId);
        assertThat(getAfterDelete.getStatusCode(), is(404));
    }
}
