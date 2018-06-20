package com.tul.ta.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tul.ta.model.airport.Airport;
import com.tul.ta.model.user.User;
import com.tul.ta.repository.UserRepository;
import com.tul.ta.service.airports.AirportService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringRunner.class)

public class AuthorizationTest {
    protected MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    private static Set<Class> inited = new HashSet<>();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
    }

    @Before
    public void init() throws Exception {
        if (!inited.contains(getClass())) {
            doInit();
            inited.add(getClass());
        }
    }

    protected String json(Object o) throws IOException {
        return mapper.writeValueAsString(o);
    }

    @Autowired
    private UserRepository userRepository;

    public void doInit() throws Exception {
        User user = new User("user", "pass");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode("pass"));
        userRepository.save(user);
    }

    @MockBean
    private AirportService airportService;
//        mockMvc.perform(get("/api/companies").header("Authorization", "Token " + token))
//                .andExpect(status().isForbidden());
    @Ignore
    @Test
    public void whenGetAirportsShouldReturnJsonArray() throws Exception {
        final String token = extractToken(login("user", "pass").andReturn());
        Airport AAL = Airport.builder()
                .airportCode("AAL")
                .cityCode("AAL")
                .countryCode("DK")
                .utcOffset(2)
                .timeZoneId("European/Copenhagen")
                .build();
        List<Airport> allAirports = Collections.singletonList(AAL);

        given(airportService.getAll()).willReturn(allAirports);

        mockMvc.perform(get("/api/flight/airports").header("Authorization", "Token " + token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].airportCode", is(AAL.getAirportCode())));
    }

    protected ResultActions login(String username, String password) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User(username, bCryptPasswordEncoder.encode(password));
        return mockMvc.perform(
                post("/login")
                        .content(json(user))
                        .contentType(MediaType.APPLICATION_JSON));
    }

    protected String extractToken(MvcResult result) throws UnsupportedEncodingException {
        return JsonPath.read(result.getResponse().getContentAsString(), "$.token");
    }
}
