/*
 * @(#)UserWrapper.java 1.0 17/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.wrappers;

import com.challenge.ce.crud.serializers.UserWrapperDeserializer;
import com.challenge.ce.crud.serializers.UserWrapperSerializer;
import com.challenge.ce.crud.user.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A classe <code>UserWrapper</code> encapsula um objeto Chat para a
 * sua serializacao e deserializacao
 *
 * @author Erik Paula
 * @version 1.0 17/01/2017
 */
@Getter
@AllArgsConstructor
@JsonSerialize(using = UserWrapperSerializer.class)
@JsonDeserialize(using = UserWrapperDeserializer.class)
public class UserWrapper {
    
    private User user;

}
