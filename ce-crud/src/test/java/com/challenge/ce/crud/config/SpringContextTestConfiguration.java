/*
 * @(#)SpringContextTestConfiguration.java 1.0 17/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * A classe <code>SpringContextTestConfiguration</code> representa o contexto do
 * Spring para testes de integracao.
 *
 * @author Erik Paula
 * @version 1.0 21/01/2017
 */
@Configuration
@ComponentScan(basePackages = {"com.challenge.ce.crud.serializers", "com.challenge.ce.crud.user"})
@EnableJpaRepositories(basePackages = {"com.challenge.ce.crud.user"})
@Import({DataBaseTestBeans.class})
@PropertySource({"classpath:datasource.properties"})
@EnableLoadTimeWeaving
@EnableAspectJAutoProxy
public class SpringContextTestConfiguration {

}
