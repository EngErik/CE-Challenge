/*
 * @(#)UserController.java 1.0 17/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.ce.crud.user.User;
import com.challenge.ce.crud.user.UserFacade;
import com.challenge.ce.crud.wrappers.UserWrapper;

/**
 * A classe <code>UserController</code> eh responsavel por receber requisicoes
 * referentes aos recursos de usuario na aplicacao.
 *
 * @author Erik Paula
 * @version 1.0 17/01/2017
 */
@RestController
public class UserController {

    private UserFacade facade;
    
    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserWrapper> createUser(@RequestBody final UserWrapper userWrapper) {
        final User user = facade.createUser(userWrapper.getUser());
        return ResponseEntity.ok().body(new UserWrapper(user));
    }
    
    @Autowired
    public void setUserFacade(final UserFacade facade) {
        this.facade = facade;
    }
}
