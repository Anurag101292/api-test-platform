package org.example.engine.assertion;

import org.example.engine.schema.SchemaValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssertEngine {

    private static final Logger log = LoggerFactory.getLogger(AssertEngine.class);

    public void assertEquals(Object actual, Object expected, String message) {
        if (actual == null && expected == null) {
            pass(AssertionType.EQUALS, message);
            return;
        }
        if (actual != null && actual.equals(expected)) {
            pass(AssertionType.EQUALS, message);
        } else {
            fail(AssertionType.EQUALS,
                    message + " | expected=[" + expected + "] but actual=[" + actual + "]");
        }
    }

    public void assertNotNull(Object obj, String message) {
        if (obj != null) {
            pass(AssertionType.NOT_NULL, message);
        } else {
            fail(AssertionType.NOT_NULL, message + " | value is null");
        }
    }

    public void assertTrue(boolean condition, String message) {
        if (condition) {
            pass(AssertionType.TRUE, message);
        } else {
            fail(AssertionType.TRUE, message + " | condition is false");
        }
    }

    public void assertFalse(boolean condition, String message) {
        if (!condition) {
            pass(AssertionType.FALSE, message);
        } else {
            fail(AssertionType.FALSE, message + " | condition is true");
        }
    }

    public void assertSchema(SchemaValidationResult result, String message) {
        if (result.isValid()) {
            pass(AssertionType.SCHEMA, message);
        } else {
            fail(AssertionType.SCHEMA,
                    message + " | schema errors: " + result.getErrors());
        }
    }

    private void pass(AssertionType type, String message) {
        log.info("✅ ASSERT PASS [{}] - {}", type, message);
    }

    private void fail(AssertionType type, String message) {
        log.error("❌ ASSERT FAIL [{}] - {}", type, message);
        throw new AssertionError(message);
    }
}
