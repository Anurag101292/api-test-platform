package org.example.engine.data;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.util.FileUtils;
import org.example.util.JsonUtils;

import java.util.Map;

public class JsonDataProvider implements TestDataProvider {

    private final String resourcePath;
    private Map<String, Object> rootData;

    public JsonDataProvider(String resourcePath) {
        this.resourcePath = resourcePath;
        load();
    }

    private void load() {
        String json = FileUtils.readResourceAsString(resourcePath);
        this.rootData = JsonUtils.fromJson(json, new TypeReference<Map<String, Object>>() {});
    }

    @SuppressWarnings("unchecked")
    @Override
    public TestData get(String key) {
        Object block = rootData.get(key);
        if (block == null) {
            throw new RuntimeException("No test data found for key: " + key);
        }
        if (!(block instanceof Map)) {
            throw new RuntimeException("Test data for key is not an object: " + key);
        }
        return new TestData((Map<String, Object>) block);
    }
}
