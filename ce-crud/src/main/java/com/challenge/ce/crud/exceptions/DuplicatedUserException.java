/*
 * @(#)User.java 1.0 22/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.exceptions;

import org.springframework.http.HttpStatus;

import com.challenge.ce.crud.restapi.MvcException;

/**
 * A classe <code>DuplicatedUserException</code> eh lancada
 * quando um usuario com o mesmo nome de um registro ja existente
 * tenta ser inserido na base
 * 
 * @author Erik Paula
 * @version 1.0 22/01/2017
 */
@MvcException(HttpStatus.PRECONDITION_FAILED)
public class DuplicatedUserException extends Exception {

    private static final long serialVersionUID = -6034612779622440997L;

    public DuplicatedUserException(final String message) {
        super(message);
    }
}
