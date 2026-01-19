package org.example.tests;

import org.example.base.BaseTest;
import org.example.engine.schema.SchemaValidationResult;
import org.example.engine.schema.SchemaValidatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SchemaEngineSanityTest extends BaseTest {

    @Test
    public void shouldValidateJsonAgainstSchema() {

        String validJson = """
                {
                  "username": "john",
                  "age": 30
                }
                """;

        SchemaValidationResult result =
                SchemaValidatorFactory.get().validate(validJson, "schemas/user.json");

        Assert.assertTrue(result.isValid(), "Schema validation should pass");
    }

    @Test
    public void shouldFailInvalidJsonAgainstSchema() {

        String invalidJson = """
                {
                  "username": "john"
                }
                """;

        SchemaValidationResult result =
                SchemaValidatorFactory.get().validate(invalidJson, "schemas/user.json");

        Assert.assertFalse(result.isValid(), "Schema validation should fail");
        Assert.assertTrue(result.getErrors().size() > 0, "Errors should be present");
    }
}
