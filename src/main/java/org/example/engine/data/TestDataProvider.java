package org.example.engine.data;

public interface TestDataProvider {

    /**
     * Load a test data object by key.
     * Example: "createBooking", "loginValidUser", etc.
     */
    TestData get(String key);
}
