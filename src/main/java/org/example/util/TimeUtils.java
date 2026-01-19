package org.example.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class TimeUtils {

    private TimeUtils() {}

    public static long nowMillis() {
        return System.currentTimeMillis();
    }

    public static String nowIso() {
        return Instant.now().toString();
    }

    public static LocalDateTime nowLocal() {
        return LocalDateTime.now(ZoneId.systemDefault());
    }

    public static void sleepMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Sleep interrupted", e);
        }
    }
}
