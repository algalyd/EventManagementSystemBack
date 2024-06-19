package com.event_manager.eventsproject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing a User in the system.
 * <p>
 * This class maps to the "users" table in the database and includes various fields
 * such as id, username, email, password, and a list of events associated with the user.
 * It also includes constructors, getters, and setters for these fields.
 * </p>
 */
@Entity
@Table(name = "users")
public class Users {

    /**
     * Constructs a new User with the specified id, username, email, password, and events.
     *
     * @param id the unique identifier of the user
     * @param username the username of the user
     * @param email the email address of the user
     * @param password the password of the user
     * @param events the list of events associated with the user
     */
    public Users(Long id, String username, String email, String password, List<Events> events) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.events = events;
    }

    /**
     * Default constructor for JPA.
     */
    public Users(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Events> events = new ArrayList<>();

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

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the list of events associated with the user.
     *
     * @return the list of events associated with the user
     */
    public List<Events> getEvents() {
        return events;
    }

    /**
     * Sets the list of events associated with the user.
     *
     * @param events the list of events associated with the user
     */
    public void setEvents(List<Events> events) {
        this.events = events;
    }
}
