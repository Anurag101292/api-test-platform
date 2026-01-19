package org.example.engine.data;

import java.util.Map;

public class TestData {

    private final Map<String, Object> data;

    public TestData(Map<String, Object> data) {
        this.data = data;
    }

    public Object get(String key) {
        return data.get(key);
    }

    public String getString(String key) {
        Object val = data.get(key);
        return val == null ? null : String.valueOf(val);
    }

    public Integer getInt(String key) {
        Object val = data.get(key);
        if (val instanceof Number) {
            return ((Number) val).intValue();
        }
        return val == null ? null : Integer.parseInt(val.toString());
    }

    public Boolean getBoolean(String key) {
        Object val = data.get(key);
        if (val instanceof Boolean) {
            return (Boolean) val;
        }
        return val == null ? null : Boolean.parseBoolean(val.toString());
    }

    public Map<String, Object> asMap() {
        return data;
    }
}
