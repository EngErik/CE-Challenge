/*
 * @(#)SerializationLabel.java 1.0 17/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.serializers;

import lombok.Getter;

/**
 * Interface que reune constantes de serializacao e deserializacao utilizados
 * pela aplicacao
 *
 * @author Erik Paula
 * @version 1.0 17/01/2017
 */
@Getter
public enum SerializationLabel {
    
    BALANCE("balance"),
    CREATION_DATE("creationDate"),
    CPF("cpf"),
    ID("id"),
    STATUS("status"),   
    USER_NAME("userName");

    private String labelValue;
    
    private SerializationLabel(final String labelValue) {
        this.labelValue = labelValue;
    }
}
