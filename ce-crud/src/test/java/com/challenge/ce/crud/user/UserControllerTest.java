/*
 * @(#)UserControllerTest.java 1.0 18/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.challenge.ce.crud.AbstractIntegrationTest;

/**
 * A classe <code>UserControllerTest</code> contem testes de integracao para a
 * classe <code>UserController</code>.
 *
 * @author Erik Paula
 * @version 1.0 18/01/2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest extends AbstractIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void prepare() throws Exception {
        mockMvc = webAppContextSetup(context).build();
        runSQLCommands("/database/create_table_ce_user.sql");
    }

    @Test
    public void createUserTest() throws Exception {
        final String request = "{\"name\":\"teste\",\"cpf\":\"12345678901\",\"balance\":1500}";

        mockMvc.perform(post("/user").content(request).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());

    }

}
