/*
 * @(#)User.BankNote 1.0 22/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.atm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * A classe <code>BankNote</code> representa uma nota/cedula de dinheiro,
 * que alimenta uma <code>Atm</code>
 *
 * @author Erik Paula
 * @version 1.0 22/01/2017
 */

@Setter
@Getter
@Table(name = "CE_NOTE")
@Entity
public class BankNote {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_NOTE", nullable = false, updatable = false)
    private Long id_note;
    
    @Setter(AccessLevel.NONE)
    @ManyToOne
    private Atm atm;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "Note value cannot be null")
    @Column(name = "VALUE")
    private BigDecimal noteValue;
    
    @Setter(AccessLevel.NONE)
    @NotNull(message = "quantity cannot be null")
    @Column(name = "QUANTITY")
    private Integer quantity;

}
