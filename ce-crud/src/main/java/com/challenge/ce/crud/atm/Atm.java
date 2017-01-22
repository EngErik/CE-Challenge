/*
 * @(#)User.java 1.0 22/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.atm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.challenge.ce.crud.enums.SystemStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * A classe <code>Atm</code> representa um caixa eletronico a ser utilizada no
 * sistema, para saques dos usuarios. Um objeto <code>Atm</code> passa a
 * existir no momento em que o mesmo eh inserido no sistema atraves da tela de
 * cadastro de caixas eletronicos.
 *
 * @author Erik Paula
 * @version 1.0 22/01/2017
 */
@Setter
@Getter
@Table(name = "CE_ATM")
@Entity
public class Atm {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_ATM", nullable = false, updatable = false)
    private Long id;
   
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Name cannot be null")
    @Column(name = "NAME")
    private String name;
    
    @Setter(AccessLevel.NONE)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BankNote> bankNotes;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Status cannot be null")
    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    private SystemStatus status;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Balance cannot be null")
    @Column(name = "BALANCE")
    private BigDecimal balance;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Creation date cannot be null")
    @Column(name = "CREATION_DATE")
    private Date creation_date;
}
