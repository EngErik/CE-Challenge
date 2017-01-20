/*
 * @(#)CECrudJsonGenerator.java 1.0 19/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.serializers;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerator;

/**
 * A classe CECrudJsonGenerator eh um proxy para a classe JsonGenerator cujo
 * objetivo eh tratar como serao serializados os valores no JSON.
 *
 * @author Erik Paula
 * @version 1.0 19/01/2017
 */
public class CECrudJsonGenerator {
    
    private static final String WHITESPACE = "";

    private final JsonGenerator generator;
    private boolean writeNullable;

    public CECrudJsonGenerator(final JsonGenerator generator) {
        this.generator = generator;
    }

    public CECrudJsonGenerator(final JsonGenerator generator, final boolean writeNullable) {
        this.generator = generator;
        this.writeNullable = writeNullable;
    }

    public void writeStartObject() throws IOException {
        generator.writeStartObject();
    }

    public void writeObjectFieldStart(final SerializationLabel fieldName) throws IOException {
        generator.writeObjectFieldStart(fieldName.getLabelValue());
    }

    public void writeNumberField(final SerializationLabel fieldName, final Long value) throws IOException {
        if (value != null) {
            generator.writeNumberField(fieldName.getLabelValue(), value);
        } else if (writeNullable) {
            generator.writeStringField(fieldName.getLabelValue(), WHITESPACE);
        }
    }

    public void writeNumberField(final SerializationLabel fieldName, final Integer value) throws IOException {
        if (value != null) {
            generator.writeNumberField(fieldName.getLabelValue(), value);
        } else if (writeNullable) {
            generator.writeStringField(fieldName.getLabelValue(), WHITESPACE);
        }
    }
    
    public void writeNumberField(final SerializationLabel fieldName, final BigDecimal value) throws IOException {
        if (value != null) {
            generator.writeNumberField(fieldName.getLabelValue(), value);
        } else if (writeNullable) {
            generator.writeStringField(fieldName.getLabelValue(), WHITESPACE);
        }
    }

    public void writeStringField(final SerializationLabel fieldName, final String value) throws IOException {
        if (value != null) {
            generator.writeStringField(fieldName.getLabelValue(), value);
        } else if (writeNullable) {
            generator.writeStringField(fieldName.getLabelValue(), WHITESPACE);
        }
    }

    public void writeStringField(final SerializationLabel fieldName, final Enum<?> enumeratedValue) throws IOException {
        writeStringField(fieldName, enumeratedValue.name());
    }

    public void writeBooleanField(final SerializationLabel fieldName, final Boolean value) throws IOException {
        if (value != null) {
            generator.writeBooleanField(fieldName.getLabelValue(), value);
        } else if (writeNullable) {
            generator.writeStringField(fieldName.getLabelValue(), WHITESPACE);
        }
    }

    public void writeArrayFieldStart(final SerializationLabel fieldName) throws IOException {
        generator.writeArrayFieldStart(fieldName.getLabelValue());
    }

    public void writeString(final String text) throws IOException {
        generator.writeString(text);
    }

    public void writeNumber(final Long value) throws IOException {
        generator.writeNumber(value);
    }

    public void writeStartArray() throws IOException {
        generator.writeStartArray();
    }

    public void writeEndArray() throws IOException {
        generator.writeEndArray();
    }

    public void writeEndObject() throws IOException {
        generator.writeEndObject();
    }

}
