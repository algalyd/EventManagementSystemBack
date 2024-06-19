package com.event_manager.eventsproject.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing an Event in the system.
 * <p>
 * This class maps to the "events" table in the database and includes fields
 * such as id, name, description, location, date, time, image, and users. It provides
 * constructors, getters, and setters for these fields.
 * </p>
 */
@Entity
public class Events {

    /**
     * Constructs a new Event with the specified id, name, description, location, date,
     * time, image, and users.
     *
     * @param id          the unique identifier of the event
     * @param name        the name of the event
     * @param description the description of the event
     * @param location    the location of the event
     * @param date        the date of the event
     * @param time        the time of the event
     * @param image       the image associated with the event
     * @param users       the list of users associated with the event
     */
    public Events(Long id, String name, String description, String location, String date, String time, String image, List<Users> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.image = image;
        this.users = users;
    }

    /**
     * Default constructor for JPA.
     */
    public Events() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "longtext")
    private String description;
    private String location;
    private String date;
    private String time;
    private String image;

    @ManyToMany
    @JoinTable(
            name = "user_events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private List<Users> users = new ArrayList<>();

    /**
     * Gets the unique identifier of the event.
     *
     * @return the unique identifier of the event
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the event.
     *
     * @param id the unique identifier of the event
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the event.
     *
     * @return the name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the event.
     *
     * @param name the name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the event.
     *
     * @return the description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the event.
     *
     * @param description the description of the event
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the location of the event.
     *
     * @return the location of the event
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the event.
     *
     * @param location the location of the event
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the date of the event.
     *
     * @return the date of the event
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the event.
     *
     * @param date the date of the event
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the time of the event.
     *
     * @return the time of the event
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the event.
     *
     * @param time the time of the event
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the image associated with the event.
     *
     * @return the image associated with the event
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image associated with the event.
     *
     * @param image the image associated with the event
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the list of users associated with the event.
     *
     * @return the list of users associated with the event
     */
    public List<Users> getUsers() {
        return users;
    }

    /**
     * Sets the list of users associated with the event.
     *
     * @param users the list of users associated with the event
     */
    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
