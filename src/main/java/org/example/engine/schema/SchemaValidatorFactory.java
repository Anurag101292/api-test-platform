package org.example.engine.schema;

public final class SchemaValidatorFactory {

    private static SchemaValidator validator;

    private SchemaValidatorFactory() {}

    public static void init(SchemaValidator schemaValidator) {
        validator = schemaValidator;
    }

    public static SchemaValidator get() {
        if (validator == null) {
            throw new IllegalStateException("SchemaValidator is not initialized");
        }
        return validator;
    }
}
