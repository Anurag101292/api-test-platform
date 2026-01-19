package org.example.util;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class FileUtils {

    private FileUtils() {}

    public static String readResourceAsString(String path) {
        try (InputStream is = ResourceUtils.getResourceAsStream(path)) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read resource: " + path, e);
        }
    }
}
