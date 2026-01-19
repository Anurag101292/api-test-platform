package org.example.engine.data;

public final class DataProviderFactory {

    private static TestDataProvider provider;

    private DataProviderFactory() {}

    public static void init(TestDataProvider testDataProvider) {
        provider = testDataProvider;
    }

    public static TestDataProvider get() {
        if (provider == null) {
            throw new IllegalStateException("TestDataProvider is not initialized");
        }
        return provider;
    }
}
