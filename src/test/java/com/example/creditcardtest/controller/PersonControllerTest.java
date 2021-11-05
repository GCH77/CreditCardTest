package com.example.creditcardtest.controller;

import com.example.creditcardtest.config.JWTUtil;
import com.example.creditcardtest.entity.Person;
import com.example.creditcardtest.service.PersonServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.http.MediaType.*;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonController.class)
class PersonControllerTest {

    /*private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Autowired
    PersonControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @MockBean
    private JWTUtil jwtUtil;

    @MockBean
    private PersonServiceImpl personService;

    private Person personOne;
    private List<Person> personList;

    @BeforeEach
    void setUp() {
        personOne = new Person(1L, "pepito", LocalDate.of(2001, 6, 23), "3201682345");
        personList = List.of(personOne);
    }

    @AfterEach
    void tearDown() {
        personOne = null;
        personList = null;
    }

    @Test
    @WithMockUser(username = "test@mail.com", password = "test123", roles = "Admin")
    void shouldReturnStatusCreatedAndPersonInfo() throws Exception {
        when(personService.save(any(Person.class))).thenReturn(personOne);

        mockMvc.perform(post("/persons/save")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personOne)))
                .andExpect(status().isCreated());

        verify(personService,times(1)).save(any(Person.class));
    }

    @Test
    void getAll() {
    }


    @Test
    void deleteById() {
    }*/
}