/*
 * @(#)UserStatus.java 1.0 17/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A classe <code>UserFacade</code> expoe as funcionalidades
 * referentes a usuarios.
 *
 * @author Erik Paula
 * @version 1.0 17/01/2017
 */
@Component
public class UserFacade {

    private UserServices userServices;
    
    public User createUser(final User user) {
        return userServices.createUser(user);
    }
    
    @Autowired
    public void setUserServices(final UserServices userServices) {
        this.userServices = userServices;
    }
}
