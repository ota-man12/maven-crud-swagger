package com.fullstack.fullstack.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstack.fullstack.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Repository class for managing User entities.
 */
@Repository
public class UserRepository {
    // In-memory storage of users
    private Map<String, User> userMap = new HashMap<>();

    // Path to the JSON file where users are stored
    private final String filePath = "src/main/resources/users.json";

    // ObjectMapper instance for JSON operations
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Initializes the repository by loading users from the JSON file.
     */
    @PostConstruct
    public void init() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                userMap = objectMapper.readValue(file, new TypeReference<Map<String, User>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves a user to the repository and updates the JSON file.
     * @param user The user to save.
     * @throws IOException If an I/O error occurs.
     */
    public void saveUser(User user) throws IOException {
        userMap.put(user.getUserId(), user);
        objectMapper.writeValue(new File(filePath), userMap);
    }

    /**
     * Retrieves a user by their ID.
     * @param userId The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     */
    public User getUser(String userId) {
        return userMap.get(userId);
    }

    /**
     * Deletes a user by their ID and updates the JSON file.
     * @param userId The ID of the user to delete.
     * @throws IOException If an I/O error occurs.
     */
    public void deleteUser(String userId) throws IOException {
        userMap.remove(userId);
        objectMapper.writeValue(new File(filePath), userMap);
    }

    /**
     * Retrieves all users.
     * @return A map of all users.
     */
    public Map<String, User> getAllUsers() {
        return userMap;
    }
}
