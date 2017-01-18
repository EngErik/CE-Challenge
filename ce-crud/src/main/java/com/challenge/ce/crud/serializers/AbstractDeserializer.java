/*
 * @(#)UserStatus.java 1.0 17/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.serializers;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * A classe <code>AbstractDeserializer</code> contem o codigo comum aos objetos
 * <i>deserializers</i> da aplicacao, como metodos que recuperam datas e textos
 * nos objetos JSON a serem deserializados.
 *
 * @author Erik Paula
 * @version 1.0 17/01/2017
 */
public abstract class AbstractDeserializer<T> extends JsonDeserializer<T> {
    
    protected String getFieldTextValue(final JsonNode node, final SerializationLabel fieldName) {
        return node.has(fieldName.getLabelValue()) ? node.get(fieldName.getLabelValue()).textValue() : null;
    }

    protected Double getFieldDoubleValue(final JsonNode node, final SerializationLabel fieldName) {
        return node.has(fieldName.getLabelValue()) ? node.get(fieldName.getLabelValue()).doubleValue() : null;
    }
    
    protected BigDecimal getFieldBigDecimalValue(final JsonNode node, final SerializationLabel fieldName) {
        return node.has(fieldName.getLabelValue()) ? node.get(fieldName.getLabelValue()).decimalValue() : null;
    }

    protected Date getFieldDateValue(final JsonNode node, final SerializationLabel fieldName) {
        return hasNonNull(node, fieldName) ? new Date(node.get(fieldName.getLabelValue()).asLong()) : null;
    }

    protected Long getFieldLongValue(final JsonNode node, final SerializationLabel fieldName) {
        return node.has(fieldName.getLabelValue()) ? node.get(fieldName.getLabelValue()).asLong() : null;
    }

    protected Integer getFieldIntegerValue(final JsonNode node, final SerializationLabel fieldName) {
        return node.has(fieldName.getLabelValue()) ? node.get(fieldName.getLabelValue()).asInt() : null;
    }

    protected boolean getFieldBooleanValue(final JsonNode node, final SerializationLabel fieldName) {
        return node.has(fieldName.getLabelValue()) ? node.get(fieldName.getLabelValue()).asBoolean() : false;
    }

    protected boolean hasNonNull(final JsonNode node, final SerializationLabel fieldName) {
        return node.hasNonNull(fieldName.getLabelValue());
    }

    protected boolean has(final JsonNode node, final SerializationLabel fieldName) {
        return node.has(fieldName.getLabelValue());
    }

    protected JsonNode get(final JsonNode node, final SerializationLabel fieldName) {
        return node.get(fieldName.getLabelValue());
    }

    protected boolean isArray(final JsonNode node, final SerializationLabel fieldName) {
        return hasNonNull(node, fieldName) && get(node, fieldName).isArray();
    }

    protected boolean isEmptyArray(final JsonNode node, final SerializationLabel fieldName) {
        return isArray(node, fieldName) && get(node, fieldName).size() == 0;
    }
}
