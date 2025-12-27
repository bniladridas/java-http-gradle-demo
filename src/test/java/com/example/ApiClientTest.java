package com.example;

import com.example.api.ApiClient;
import com.example.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiClientTest {
    @Test
    public void testGetUser() throws Exception {
        ApiClient client = new ApiClient();
        User user = client.get("https://jsonplaceholder.typicode.com/users/1", User.class);
        assertNotNull(user);
        assertEquals(1, user.getId());
    }
}