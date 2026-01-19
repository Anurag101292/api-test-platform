package org.example.util;

import java.io.InputStream;

public final class ResourceUtils {

    private ResourceUtils() {}

    public static InputStream getResourceAsStream(String path) {
        InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(path);

        if (is == null) {
            throw new RuntimeException("Resource not found in classpath: " + path);
        }
        return is;
    }
}
