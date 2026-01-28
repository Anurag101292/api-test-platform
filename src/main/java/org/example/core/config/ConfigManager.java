package org.example.core.config;


import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigManager {

    private static Map<String, Object> config;

    static {
        load();
    }

    private static void load() {
        Yaml yaml = new Yaml();
        InputStream is = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream("config.yaml");

        config = yaml.load(is);
    }

    @SuppressWarnings("unchecked")
    public static Object get(String key) {
        String[] parts = key.split("\\.");
        Object value = config;

        for (String part : parts) {
            value = ((Map<String, Object>) value).get(part);
        }
        return value;
    }

    public static String getString(String key) {
        return get(key).toString();
    }

    public static String getEnv() {
        return (String) config.get("env");
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getEnvConfig() {
        return (Map<String, Object>) config.get(getEnv());
    }
}
