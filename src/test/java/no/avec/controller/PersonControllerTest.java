package no.avec.controller;

//import no.avec.domain.Person;
import no.avec.domain.Person;
import no.avec.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
import javax.ws.rs.core.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by avec on 26/11/2016.
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(PersonController.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@DataJpaTest
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private PersonController controller;

//    @Autowired
//    private TestRestTemplate restTemplate;

//    @MockBean
    private PersonRepository personRepository;
/*
    @Test
    public void findPerson() throws Exception {
        given(personRepository.findOne(1L)).willReturn(new Person(1L, "Fornavn", "Etternavn", 10, Person.Sex.MALE));
//        this.mockMvc.perform(get("/person/1").accept(MediaType.APPLICATION_JSON))
        this.mockMvc.perform(get("/person/1").accept(MediaType.parseMediaType("application/person-1.0+json")))
                .andExpect(status().isOk());

    }*/

//    @Test
    public void findAll() throws Exception {
//        when(controller.findAll()).thenReturn(Arrays.asList(new Person2("Fornavn", "Etternavn", 10, Person2.Sex.MALE)));
        given(personRepository.findAll()).willReturn(Arrays.asList(new Person("Fornavn", "Etternavn", 10, Person.Sex.MALE)));
//        given(personRepository.findAll()).willReturn(Arrays.asList(new Person2("Fornavn", "Etternavn", 10, Person2.Sex.MALE)));
//        Iterable<Person> persons = personRepository.findAll();
//        when(personRepository.findAll()).thenReturn(Arrays.asList(new Person(0L, "Fornavn", "Etternavn", 10, Person.Sex.MALE)));
        this.mockMvc.perform(get("/person").accept(MediaType.APPLICATION_JSON))
//        this.mockMvc.perform(get("/person").accept(MediaType.parseMediaType("application/person-1.0+json")))
//        this.mockMvc.perform(get("/person").accept("application/prs.person-1.0+json"))
//        mockMvc.perform(get("/person").accept("application/json"))
//                .andExpect(status().is4xxClientError());
                .andExpect(header().string("test", "value"))
                .andExpect(status().isOk());
//                .andExpect(content().contentType("application/json"));
//                .andExpect(content().contentType("application/person-1.0+json"));
    }

//    @Test
    public void findAllv2() throws Exception {
//        final ResponseEntity<Person2> entity = this.restTemplate.getForEntity("/person", Person2.class);
//        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
    }

}