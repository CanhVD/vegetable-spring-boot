package com.example.vegetable_shop.configuration.jackson;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

public class StringTrimmerDeserializer extends ValueDeserializer<String> {
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        String value = p.getValueAsString();
        if (value != null) {
            return value.trim();
        }
        return null;
    }
}