package com.tul.ta.controller;


import com.tul.ta.model.user.User;
import com.tul.ta.service.users.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @RunWith(SpringRunner.class)
    @WebMvcTest(RegistrationController.class)
    public class RegistrationControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private UserService userService;


        @Test
        public void whenGetAirportsShouldReturnJsonArray() throws Exception {
            User alex = new User("alex", "p");


            List<User> allAirports = Collections.singletonList(alex);

            given(userService.getAll()).willReturn(allAirports);

            mockMvc.perform(get("/api/flight/airports")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$[0].airportCode", is(alex.getUsername())));
        }
    }
