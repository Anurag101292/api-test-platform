package org.example.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomDataUtils {

    private RandomDataUtils() {}

    public static String randomString() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String randomString(int length) {
        String base = randomString();
        return base.substring(0, Math.min(length, base.length()));
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
