/*
 * @(#)MvcException.java 1.0 22/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.restapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.http.HttpStatus;

/**
 * A anotação <code>MvcException</code> indica que uma exceção é mapeada para um
 * status HTTP.
 *
 * @author Erik Paula
 * @version 1.0 22/01/2017
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MvcException {

    public abstract HttpStatus value();
}
