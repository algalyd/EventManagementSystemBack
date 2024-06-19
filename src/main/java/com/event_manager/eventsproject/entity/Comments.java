package com.event_manager.eventsproject.entity;

import jakarta.persistence.*;

/**
 * Entity class representing a comment on an event in the system.
 * <p>
 * This class maps to the "comments" table in the database and includes fields
 * such as id, userId, eventId, message, date, and username. It provides constructors,
 * getters, and setters for these fields.
 * </p>
 */
@Entity
public class Comments {

    /**
     * Constructs a new Comment with the specified id, userId, eventId, message, date, and username.
     *
     * @param id       the unique identifier of the comment
     * @param userId   the ID of the user who posted the comment
     * @param eventId  the ID of the event associated with the comment
     * @param message  the content of the comment
     * @param date     the date when the comment was posted
     * @param username the username of the user who posted the comment
     */
    public Comments(Long id, Long userId, Long eventId, String message, String date, String username) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.date = date;
        this.eventId = eventId;
        this.username = username;
    }

    /**
     * Default constructor for JPA.
     */
    public Comments(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long userId;
    private Long eventId;
    private String date;
    private String username;

    /**
     * Gets the unique identifier of the comment.
     *
     * @return the unique identifier of the comment
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the comment.
     *
     * @param id the unique identifier of the comment
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the content of the comment.
     *
     * @return the content of the comment
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the content of the comment.
     *
     * @param message the content of the comment
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the ID of the user who posted the comment.
     *
     * @return the ID of the user who posted the comment
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who posted the comment.
     *
     * @param userId the ID of the user who posted the comment
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the date when the comment was posted.
     *
     * @return the date when the comment was posted
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date when the comment was posted.
     *
     * @param date the date when the comment was posted
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the ID of the event associated with the comment.
     *
     * @return the ID of the event associated with the comment
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Sets the ID of the event associated with the comment.
     *
     * @param eventId the ID of the event associated with the comment
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * Gets the username of the user who posted the comment.
     *
     * @return the username of the user who posted the comment
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user who posted the comment.
     *
     * @param username the username of the user who posted the comment
     */
    public void setUsername(String username) {
        this.username = username;
    }
}

