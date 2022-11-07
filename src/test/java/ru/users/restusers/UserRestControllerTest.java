package ru.users.restusers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.users.restusers.UserTestData.*;

class UserRestControllerTest extends AbstractControllerTest{

    private static final String REST_URL = "/users/";

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();
        repository.save(USER1);
        repository.save(USER2);
    }

    @Test
    void createRestTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL+"insert")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        assertTrue(repository.findById(3L).isPresent());
    }

    @Test
    void get() throws Exception {
        MvcResult result = mockMvc.
                perform(MockMvcRequestBuilders.get(REST_URL+"1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        User user = jsonToUser(result.getResponse().getContentAsString(), User.class);
        assertNotNull(user);
        assertEquals(user, USER1);
    }

    @Test
    void getAll() throws Exception {
        MvcResult result = mockMvc.
                perform(MockMvcRequestBuilders.get(REST_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String users = result.getResponse().getContentAsString();
        assertNotNull(users);
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(REST_URL+"1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
        assertFalse(repository.findById(1L).isPresent());
    }

    @Test
    void createRest() throws Exception {
        User user = getNew();
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(user)))
                .andExpect(status().isCreated())
                .andReturn();
        User created;
        if(repository.findById(3L).isPresent()) {
            created = repository.findById(3L).get();
            user.setId(created.getId());
            assertEquals(created, user);
        }
    }

    @Test
    void update() throws Exception {
        User user = getUpdated();
        mockMvc.perform(MockMvcRequestBuilders.put(REST_URL+"1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(user)))
                .andExpect(status().isNoContent())
                .andReturn();
        if(repository.findById(1L).isPresent()) {
            assertEquals(repository.findById(1L).get(), getUpdated());
        }
    }
}