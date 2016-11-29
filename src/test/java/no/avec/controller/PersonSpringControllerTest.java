package no.avec.controller;

import no.avec.domain.Person;
import no.avec.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by avec on 28/11/2016.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonSpringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {
        given(personRepository.findAll()).willReturn(Collections.singletonList(new Person("John", "Doe", 10, Person.Sex.MALE)));
    }

    @Test
    public void findPerson() throws Exception {
        getByAcceptHeader("application/person-1.0+json");
    }

    @Test
    public void findPerson_v2_0() throws Exception {
        getByAcceptHeader("application/person-2.0+json");
    }

    @Test
    public void findPerson_status_406() throws Exception {
        // Non existing versjon (person-9.9)
        this.mockMvc.perform(get("/person").accept("application/person-9.9+json"))
                .andExpect(status().is(406));
    }


    private void getByAcceptHeader(String mediaTypeVersion) throws Exception {
        this.mockMvc.perform(get("/person").accept(mediaTypeVersion))
                .andExpect(status().isOk())
                .andExpect(content().string("[ {\n" +
                        "  \"firstName\" : \"John\",\n" +
                        "  \"lastName\" : \"Doe\",\n" +
                        "  \"age\" : 10,\n" +
                        "  \"sex\" : \"MALE\",\n" +
                        "  \"id\" : 0\n" +
                        "} ]"));
    }
}