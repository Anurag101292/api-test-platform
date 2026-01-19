package org.example.engine.schema;

public interface SchemaValidator {

    /**
     * Validate a JSON string against a schema resource.
     *
     * @param json          JSON payload
     * @param schemaPath    classpath resource path to schema (e.g. "schemas/booking.json")
     */
    SchemaValidationResult validate(String json, String schemaPath);
}
