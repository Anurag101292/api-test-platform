package org.example.tests;

import org.example.base.BaseTest;
import org.example.engine.assertion.Assertions;
import org.example.engine.schema.SchemaValidationResult;
import org.example.engine.schema.SchemaValidatorFactory;
import org.testng.annotations.Test;

public class AssertionEngineSanityTest extends BaseTest {

    @Test
    public void shouldAssertBasicThings() {

        Assertions.assertEquals(5, 5, "5 should equal 5");
        Assertions.assertNotNull("abc", "string should not be null");
        Assertions.assertTrue(10 > 1, "10 > 1 should be true");
        Assertions.assertFalse(1 > 10, "1 > 10 should be false");
    }

    @Test
    public void shouldAssertSchema() {

        String json = """
                {
                  "username": "john",
                  "age": 30
                }
                """;

        SchemaValidationResult result =
                SchemaValidatorFactory.get().validate(json, "schemas/user.json");

        Assertions.assertSchema(result, "User schema should be valid");
    }
}
