package org.example.engine.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SchemaValidatorsConfig;
import com.networknt.schema.SpecVersionDetector;
import com.networknt.schema.ValidationMessage;
import org.example.util.ResourceUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonSchemaValidator implements SchemaValidator {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public SchemaValidationResult validate(String json, String schemaPath) {
        try {
            InputStream schemaStream = ResourceUtils.getResourceAsStream(schemaPath);

            JsonNode schemaNode = mapper.readTree(schemaStream);
            JsonNode jsonNode = mapper.readTree(json);

            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersionDetector.detect(schemaNode));

            SchemaValidatorsConfig config = new SchemaValidatorsConfig();
            JsonSchema schema = factory.getSchema(schemaNode, config);

            Set<ValidationMessage> errors = schema.validate(jsonNode);

            if (errors == null || errors.isEmpty()) {
                return SchemaValidationResult.ok();
            }

            List<String> msgs = errors.stream()
                    .map(ValidationMessage::getMessage)
                    .collect(Collectors.toList());

            return SchemaValidationResult.failed(msgs);

        } catch (Exception e) {
            throw new RuntimeException("Schema validation failed to execute", e);
        }
    }
}
