package com.fullstack.fullstack.model;

/**
 * Represents a User in the system.
 */
public class User {
    // Unique identifier for the user
    private String userId;

    // User's first name
    private String firstName;

    // User's last name
    private String lastName;

    // User's contact number
    private String contactNumber;

    /**
     * Gets the user's ID.
     * 
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user's ID.
     * 
     * @param userId The user ID to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the user's first name.
     * 
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     * 
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     * 
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     * 
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's contact number.
     * 
     * @return The contact number.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the user's contact number.
     * 
     * @param contactNumber The contact number to set.
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
