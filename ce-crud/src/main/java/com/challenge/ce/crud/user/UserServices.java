/*
 * @(#)UserServices.java 1.0 18/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.ce.crud.exceptions.DuplicatedUserException;

/**
 * A classe <code>UserServices</code> contem metodos de suporte a operacoes
 * relacionadas a objetos <code>User</code>.
 *
 * @author Erik Paula
 * @version 1.0 21/01/2017
 */
@Component
public class UserServices {
    
    private UserRepository userRepository;

    public User createUser(final User user) throws DuplicatedUserException {
        if(userRepository.findByName(user.getName()) != null) {
            throw new DuplicatedUserException("Duplicated user!");
        }
        final User createdUser = userRepository.save(user);
        return createdUser;
    }
    
    public User getUser(final long id) {
        return userRepository.findOne(id);
    }
    
    @Autowired
    public void setUserRepository(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
