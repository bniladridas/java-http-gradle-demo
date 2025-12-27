package com.example;

import com.example.model.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    @Test
    public void testGetUser() throws Exception {
        UserService userService = new UserService(new com.example.api.ApiClient());
        User user = userService.getUser(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("Leanne Graham", user.getName());
    }

    @Test
    public void testCreateUser() throws Exception {
        UserService userService = new UserService(new com.example.api.ApiClient());
        User newUser = new User(0, "Test User", "testuser", "test@example.com", "000-000-0000", "test.com");
        User created = userService.createUser(newUser);
        assertNotNull(created);
        assertEquals("Test User", created.getName());
        // JSONPlaceholder assigns id 11 for POST
        assertTrue(created.getId() > 0);
    }
}