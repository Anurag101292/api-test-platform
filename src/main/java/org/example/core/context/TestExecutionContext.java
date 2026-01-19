package org.example.core.context;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestExecutionContext {

    private static final Map<String, Object> context = new ConcurrentHashMap<>();

    private TestExecutionContext() {
        // Prevent instantiation
    }

    // ---- Basic operations ----

    public static void put(String key, Object value) {
        context.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) context.get(key);
    }

    public static boolean contains(String key) {
        return context.containsKey(key);
    }

    public static void clear() {
        context.clear();
    }

    // ---- Typed helpers (convenience) ----

    public static void setEnv(String env) {
        put("env", env);
    }

    public static String getEnv() {
        return get("env");
    }

    public static void setConfig(Map<String, Object> config) {
        put("config", config);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getConfig() {
        return get("config");
    }
}
