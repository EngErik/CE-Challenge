/*
 * @(#)UserWrapperDeserializer.java 1.0 17/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.serializers;

import static com.challenge.ce.crud.serializers.SerializationLabel.BALANCE;
import static com.challenge.ce.crud.serializers.SerializationLabel.CPF;
import static com.challenge.ce.crud.serializers.SerializationLabel.USER_NAME;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.challenge.ce.crud.user.User;
import com.challenge.ce.crud.wrappers.UserWrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * A classe {@link UserWrapperDeserializer} eh responsavel pela conversao de conteudo
 * JSON em objetos do tipo {@link User}
 *
 * @author Glauber Shibata
 * @version 1.0 12/08/2016
 */
@Component
public class UserWrapperDeserializer extends AbstractDeserializer<UserWrapper> {

    @Override
    public UserWrapper deserialize(final JsonParser parser, final DeserializationContext ctx) throws IOException, JsonProcessingException {
        final ObjectCodec oc = parser.getCodec();
        final JsonNode node = oc.readTree(parser);
        final String userName = getFieldTextValue(node, USER_NAME);
        final String cpf = getFieldTextValue(node, CPF);
        final BigDecimal balance = getFieldBigDecimalValue(node, BALANCE);
        final User user = new User(userName, cpf, balance);
        return new UserWrapper(user);
    }

}
