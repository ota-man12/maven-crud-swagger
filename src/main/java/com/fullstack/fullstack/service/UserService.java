package com.fullstack.fullstack.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.fullstack.model.User;
import com.fullstack.fullstack.repository.UserRepository;

/**
 * Service class for managing User entities.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Adds a new user.
     * @param user The user to add.
     * @throws IOException If an I/O error occurs while saving the user.
     */
    public void addUser(User user) throws IOException {
        userRepository.saveUser(user);
    }

    /**
     * Retrieves a user by their ID.
     * @param userId The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     */
    public User getUser(String userId) {
        return userRepository.getUser(userId);
    }

    /**
     * Retrieves all users.
     * @return A map of all users.
     */
    public Map<String, User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    /**
     * Updates an existing user.
     * @param user The user with updated information.
     * @throws IOException If an I/O error occurs while saving the user.
     */
    public void updateUser(User user) throws IOException {
        userRepository.saveUser(user);
    }

    /**
     * Deletes a user by their ID.
     * @param userId The ID of the user to delete.
     * @throws IOException If an I/O error occurs while deleting the user.
     */
    public void deleteUser(String userId) throws IOException {
        userRepository.deleteUser(userId);
    }
}
