package org.example.engine.schema;

import java.util.Collections;
import java.util.List;

public class SchemaValidationResult {

    private final boolean valid;
    private final List<String> errors;

    private SchemaValidationResult(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = errors == null ? List.of() : errors;
    }

    public static SchemaValidationResult ok() {
        return new SchemaValidationResult(true, Collections.emptyList());
    }

    public static SchemaValidationResult failed(List<String> errors) {
        return new SchemaValidationResult(false, errors);
    }

    public boolean isValid() {
        return valid;
    }

    public List<String> getErrors() {
        return errors;
    }
}
