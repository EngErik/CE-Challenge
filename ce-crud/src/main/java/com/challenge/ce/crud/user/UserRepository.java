/*
 * @(#)User.java 1.0 17/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.user;

import org.springframework.data.repository.CrudRepository;

/**
 * A interface <code>UserRepository</code> representa o repositorio de objetos
 * <code>User</code>.
 *
 * @author Erik Pàula
 * @version 1.0 17/01/2017
 */
public interface UserRepository extends CrudRepository<User, Long>  {
    
    User findByName(final String name);

}
