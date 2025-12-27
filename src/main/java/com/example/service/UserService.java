package com.example.service;

import com.example.api.ApiClient;
import com.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserService {
    private final ApiClient apiClient;
    private final String baseUrl;

    public UserService(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.baseUrl = loadBaseUrl();
    }

    private String loadBaseUrl() {
        Properties properties = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (is != null) {
                properties.load(is);
                String url = properties.getProperty("api.base.url");
                if (url != null && !url.isEmpty()) {
                    return url;
                }
            }
        } catch (IOException e) {
            // ignore, use fallback
        }
        return "https://jsonplaceholder.typicode.com";
    }

    public User getUser(int id) throws IOException, InterruptedException {
        String url = baseUrl + "/users/" + id;
        return apiClient.get(url, User.class);
    }
}