/*
 * @(#)SpringContextTestConfiguration.java 1.0 21/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * A classe <code>DatabaseTestBeans</code> contém a definição de <i>beans</i> do
 * Spring referentes a configuração de base de dados para testes de integração.
 *
 * @author Erik Paula
 * @version 1.0 21/01/2017
 */
@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class DataBaseTestBeans {

    @Bean
    public DataSource dataSource(final HikariConfig config) {
        return new HikariDataSource(config);
    }
    
    @Bean
    public HikariConfig hikariConfig(@Value("${datasource.class}") final String dataSource, @Qualifier("hikariProperties") final Properties hikariProperties) {
        final HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(dataSource);
        config.setMaximumPoolSize(10);
        config.setIdleTimeout(30000);
        config.setConnectionTestQuery("select 1 from information_schema.system_users");
        config.setDataSourceProperties(hikariProperties);
        return config;
    }

    @Bean
    @Qualifier("hikariProperties")
    public Properties hikariProperties(@Value("${datasource.url}") final String url, @Value("${datasource.username}") final String username,
            @Value("${datasource.password}") final String password) {
        final Properties properties = new Properties();
        properties.setProperty("url", url);
        properties.setProperty("user", username);
        properties.setProperty("password", password);
        return properties;
    }
    
    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setDatabase(Database.HSQL);
        adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
        return adapter;
    }

    @Bean
    public JpaDialect dialect() {
        return new HibernateJpaDialect();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource, final JpaVendorAdapter jpaVendorAdapter,
            final JpaDialect dialect, final ValidatorFactory validatorFactoryBean) {

        final Map<String, Object> propertiesMap = new HashMap<>();
        propertiesMap.put("javax.persistence.validation.factory", validatorFactoryBean);

        final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setDataSource(dataSource);
        emfb.setJpaPropertyMap(propertiesMap);
        emfb.setJpaDialect(dialect);
        emfb.setPersistenceUnitName("CECrudPersistenceUnit");
        emfb.setPersistenceXmlLocation("classpath*:/com/challenge/ce/crud/resources/persistence.xml");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(final EntityManagerFactory factory, final DataSource dataSource, final JpaDialect dialect) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(factory);
        transactionManager.setJpaDialect(dialect);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
