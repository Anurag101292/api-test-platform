package org.example.engine.assertion;

public class AssertionResult {

    private final boolean success;
    private final AssertionType type;
    private final String message;

    private AssertionResult(boolean success, AssertionType type, String message) {
        this.success = success;
        this.type = type;
        this.message = message;
    }

    public static AssertionResult pass(AssertionType type, String message) {
        return new AssertionResult(true, type, message);
    }

    public static AssertionResult fail(AssertionType type, String message) {
        return new AssertionResult(false, type, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public AssertionType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
