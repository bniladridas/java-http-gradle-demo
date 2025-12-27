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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}