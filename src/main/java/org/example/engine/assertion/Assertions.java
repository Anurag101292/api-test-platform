package org.example.engine.assertion;

import org.example.engine.schema.SchemaValidationResult;

public final class Assertions {

    private static final AssertEngine engine = new AssertEngine();

    private Assertions() {}

    public static void assertEquals(Object actual, Object expected, String message) {
        engine.assertEquals(actual, expected, message);
    }

    public static void assertNotNull(Object obj, String message) {
        engine.assertNotNull(obj, message);
    }

    public static void assertTrue(boolean condition, String message) {
        engine.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition, String message) {
        engine.assertFalse(condition, message);
    }

    public static void assertSchema(SchemaValidationResult result, String message) {
        engine.assertSchema(result, message);
    }
}
