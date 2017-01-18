/*
 * @(#)UserServices.java 1.0 18/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A classe <code>UserServices</code> contem metodos de suporte a operacoes
 * relacionadas a objetos <code>User</code>.
 *
 * @author Rafael Ito
 * @version 1.0 24/05/2016
 */
@Component
public class UserServices {
    
    private UserRepository userRepository;

    public User createUser(final User user) {
        final User createdUser = userRepository.save(user);
        return createdUser;
    }
    
    @Autowired
    public void setUserRepository(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
