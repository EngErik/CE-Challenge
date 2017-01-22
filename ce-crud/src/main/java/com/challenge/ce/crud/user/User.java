/*
 * @(#)User.java 1.0 16/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.user;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.challenge.ce.crud.enums.SystemStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * A classe <code>User</code> representa um usuario que possui uma conta a ser
 * utilizada no caixa eletronico. Um objeto <code>User</code> passa a existir no
 * momento em que o mesmo eh inserido no sistema atraves da tela de cadastro de
 * usuarios.
 *
 * @author Erik Paula
 * @version 1.0 16/01/2017
 */
@Getter
@Setter
@Table(name = "CE_USER")
@AllArgsConstructor
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_USER", nullable = false, updatable = false)
    private Long id;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Name cannot be null")
    @Column(name = "NAME")
    private String name;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Balance cannot be null")
    @Column(name = "BALANCE")
    private BigDecimal balance;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Status cannot be null")
    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    private SystemStatus status;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Creation date cannot be null")
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    
    /**
     * Construtor padrao da classe User. 
     * 
     */
    private User() {
    }
    
    public User(final String name, final String cpf, final BigDecimal balance) {
        if (balance.equals(BigDecimal.ZERO) || balance.signum() == -1) {
            throw new IllegalArgumentException("User ballance cannot be 0 or negative!");
        }
        this.name = name;
        this.balance = balance;
        this.status = SystemStatus.ACTIVE;
        this.creationDate = new Date();
    }
    
}
