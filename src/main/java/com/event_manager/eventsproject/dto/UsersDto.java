package com.event_manager.eventsproject.dto;

/**
 * Data Transfer Object (DTO) representing a user in the system.
 * <p>
 * This class includes fields such as id, username, and email. It provides constructors,
 * getters, and setters for these fields.
 * </p>
 */
public class UsersDto {
    private Long id;
    private String username;
    private String email;

    /**
     * Constructs a new UsersDto with the specified id, email, and username.
     *
     * @param id       the unique identifier of the user
     * @param email    the email address of the user
     * @param username the username of the user
     */
    public UsersDto(Long id,String email, String username) {
        this.email = email;
        this.username = username;
        this.id = id;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return the unique identifier of the user
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id the unique identifier of the user
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the email address of the user.
     *
     * @return the email address of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email the email address of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

}

