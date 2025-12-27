package com.example;

import com.example.api.ApiClient;
import com.example.model.User;
import com.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        UserService userService = new UserService(apiClient);

        try {
            User user = userService.getUser(1);
            System.out.println("Fetched user: " + user);

            // Demo POST: create a new user
            User newUser = new User(0, "John Doe", "johndoe", "john@example.com", "123-456-7890", "johndoe.com");
            User created = userService.createUser(newUser);
            System.out.println("Created user: " + created);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}