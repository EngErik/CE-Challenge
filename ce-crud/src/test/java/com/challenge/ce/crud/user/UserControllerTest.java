/*
 * @(#)UserControllerTest.java 1.0 18/01/2017
 *
 * Copyright (c) 2017, Erik Paula. All rights reserved. 
 */
package com.challenge.ce.crud.user;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.challenge.ce.crud.AbstractIntegrationTest;
import com.challenge.ce.crud.config.SpringContextTestConfiguration;
import com.challenge.ce.crud.config.WebConfig;

/**
 * A classe <code>UserControllerTest</code> contem testes de integracao para a
 * classe <code>UserController</code>.
 *
 * @author Erik Paula
 * @version 1.0 18/01/2017
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringContextTestConfiguration.class, WebConfig.class })
public class UserControllerTest extends AbstractIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    private static final String GET_USER_TEST_EXPECTED_RESULT = "{\"id\":1,\"name\":\"teste\",\"status\":\"ACTIVE\",\"balance\":2000}";

    @Before
    public void prepare() throws Exception {
        runSQLCommands("/database/create_table_ce_user.sql");
        mockMvc = webAppContextSetup(context).build();
    }

    @After
    public void terminate() throws Exception {
        runSQLCommands("/database/drop_table_ce_user.sql");
    }

    @Test
    public void createUserTest() throws Exception {
        final String request = "{\"name\":\"teste\",\"balance\":1500}";

        mockMvc.perform(post("/user").content(request).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());

    }

    @Test
    public void getUserTest() throws Exception {
        runSQLCommands("/database/create_user.sql");
        final MvcResult result = mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk()).andReturn();

        final String jsonResponse = result.getResponse().getContentAsString();
        JSONAssert.assertEquals(GET_USER_TEST_EXPECTED_RESULT, jsonResponse, false);
    }

    @Test
    public void userCannotBeDuplicated() throws Exception {
        runSQLCommands("/database/create_user.sql");
        final String request = "{\"name\":\"teste\",\"balance\":20000}";

        assertThatThrownBy(() -> mockMvc
                .perform(post("/user").content(request).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
                        .hasMessageContaining("Duplicated user!");
    }
    
    @Test
    public void userCannotBeCreatedWithBalanceEqualsZeroTest() throws Exception {
        final String request = "{\"name\":\"teste\",\"balance\":0}";

        assertThatThrownBy(() -> mockMvc
                .perform(post("/user").content(request).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
                        .hasMessageContaining("User ballance cannot be 0 or negative!");
    }
    
    @Test
    public void userCannotBeCreatedWithNegativeBalanceTest() throws Exception {
        final String request = "{\"name\":\"teste\",\"balance\":-28989}";

        assertThatThrownBy(() -> mockMvc
                .perform(post("/user").content(request).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
                        .hasMessageContaining("User ballance cannot be 0 or negative!");
    }

}
