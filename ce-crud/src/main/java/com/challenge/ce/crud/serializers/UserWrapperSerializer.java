/*
 * @(#)UserWrapperSerializer.java 1.0 19/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.serializers;

import static com.challenge.ce.crud.serializers.SerializationLabel.BALANCE;
import static com.challenge.ce.crud.serializers.SerializationLabel.ID;
import static com.challenge.ce.crud.serializers.SerializationLabel.STATUS;
import static com.challenge.ce.crud.serializers.SerializationLabel.USER_NAME;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.challenge.ce.crud.user.User;
import com.challenge.ce.crud.wrappers.UserWrapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * A classe <code>UserWrapperSerializer</code> eh um <i>serializer</i>, que
 * transforma um registro de User do sistema em um JSON
 *
 * @author Erik Paula
 * @version 1.0 19/01/2017
 */
@Component
public class UserWrapperSerializer extends JsonSerializer<UserWrapper>{

    @Override
    public void serialize(final UserWrapper wrapper, final JsonGenerator gen, SerializerProvider serializer)
            throws IOException, JsonProcessingException {
        final CECrudJsonGenerator generator = new CECrudJsonGenerator(gen);
        final User user = wrapper.getUser();
        
        generator.writeStartObject();
        
        generator.writeNumberField(ID, user.getId());
        generator.writeStringField(USER_NAME, user.getName());
        generator.writeStringField(STATUS, user.getStatus());
        generator.writeNumberField(BALANCE, user.getBalance());
        
        generator.writeEndObject();
    }

}
