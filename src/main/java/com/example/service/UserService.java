package com.example.service;

import com.example.api.ApiClient;
import com.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    private final ApiClient apiClient;
    private final String baseUrl;

    public UserService(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.baseUrl = loadBaseUrl();
    }

    private String loadBaseUrl() {
        String candidateUrl = null;

        // Check environment variable first
        String envUrl = System.getenv("API_BASE_URL");
        if (envUrl != null && !envUrl.isEmpty()) {
            candidateUrl = envUrl;
        }

        // Fallback to properties file
        if (candidateUrl == null) {
            Properties properties = new Properties();
            try (InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties")) {
                if (is != null) {
                    properties.load(is);
                    String url = properties.getProperty("api.base.url");
                    if (url != null && !url.isEmpty()) {
                        candidateUrl = url;
                    }
                }
            } catch (IOException e) {
                // ignore, use fallback
            }
        }

        // Validate the URL
        if (candidateUrl != null) {
            if (!isValidBaseUrl(candidateUrl)) {
                String errorMessage = "Invalid API base URL: " + candidateUrl;
                logger.severe(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
            return candidateUrl;
        }

        return "https://jsonplaceholder.typicode.com";
    }

    private boolean isValidBaseUrl(String url) {
        return url.startsWith("https://jsonplaceholder.typicode.com");
    }

    public User getUser(int id) throws IOException, InterruptedException {
        String url = baseUrl + "/users/" + id;
        return apiClient.get(url, User.class);
    }

    public User createUser(User user) throws IOException, InterruptedException {
        String url = baseUrl + "/users";
        return apiClient.post(url, user, User.class);
    }
}