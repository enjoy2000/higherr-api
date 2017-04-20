package com.higherr.api;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by hatdao on 19/04/2017.
 */
public class UserRepositoryTests extends HigherrApiApplicationTests {

    @Test
    public void getUsersListTest() throws Exception {

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.users", hasSize(1)))
                ;
    }

    @Test
    public void rootIndexTest() throws Exception {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("/profile");

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserWithoutTokenTest() {
        String body = this.restTemplate.getForObject("/user", String.class);
        assertThat(body).contains("Unauthorized");
    }

    @Test
    public void getTokenWithUserCredentialsTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("username", "test");
        map.add("password", "test");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        String body = this.restTemplate.postForObject("/auth", request, String.class);
        assertThat(body).doesNotContain("Unauthorized");
    }
}
