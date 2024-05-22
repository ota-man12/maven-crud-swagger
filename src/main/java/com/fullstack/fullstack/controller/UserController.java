package com.fullstack.fullstack.controller;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.fullstack.model.User;
import com.fullstack.fullstack.service.UserService;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Adds a new user.
     * 
     * @param user The user to add.
     * @return ResponseEntity indicating the result of the operation.
     */
    @PutMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            logger.info("Added user: " + user);
            return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
        } catch (IOException e) {
            logger.error("Error adding user: " + user, e);
            return new ResponseEntity<>("Error adding user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates an existing user.
     * 
     * @param userId The ID of the user to update.
     * @param user   The updated user data.
     * @return ResponseEntity indicating the result of the operation.
     */
    @PostMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody User user) {
        try {
            user.setUserId(userId);
            userService.updateUser(user);
            logger.info("Updated user: " + user);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (IOException e) {
            logger.error("Error updating user: " + user, e);
            return new ResponseEntity<>("Error updating user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves a user by ID.
     * 
     * @param userId The ID of the user to retrieve.
     * @return ResponseEntity containing the user data or a not found status.
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        if (user != null) {
            logger.info("Retrieved user: " + user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            logger.warn("User not found: " + userId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves all users.
     * 
     * @return ResponseEntity containing a list of all users or an error status.
     */
    @GetMapping
    public ResponseEntity<Map<String, User>> getAllUsers() {
        Map<String, User> allUsers = userService.getAllUsers();
        if (!allUsers.isEmpty()) {
            logger.info("Retrieved all users");
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } else {
            logger.warn("No users found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes a user by ID.
     * 
     * @param userId The ID of the user to delete.
     * @return ResponseEntity indicating the result of the operation.
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        try {
            userService.deleteUser(userId);
            logger.info("Deleted user: " + userId);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (IOException e) {
            logger.error("Error deleting user: " + userId, e);
            return new ResponseEntity<>("Error deleting user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
