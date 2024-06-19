package com.event_manager.eventsproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a notification in the system.
 * <p>
 * This class maps to the "notifications" table in the database and includes fields
 * such as id, userId, message, and context. It provides constructors, getters,
 * and setters for these fields.
 * </p>
 */
@Entity
public class Notifications {

    /**
     * Constructs a new Notification with the specified id, userId, message, and context.
     *
     * @param id       the unique identifier of the notification
     * @param userId   the ID of the user associated with the notification
     * @param message  the message content of the notification
     * @param context  the context or additional information related to the notification
     */
    public Notifications(Long id, Long userId, String message, String context) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.context = context;
    }

    /**
     * Default constructor for JPA.
     */
    public Notifications(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long userId;
    private String context;

    /**
     * Gets the unique identifier of the notification.
     *
     * @return the unique identifier of the notification
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the notification.
     *
     * @param id the unique identifier of the notification
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the message content of the notification.
     *
     * @return the message content of the notification
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content of the notification.
     *
     * @param message the message content of the notification
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the ID of the user associated with the notification.
     *
     * @return the ID of the user associated with the notification
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user associated with the notification.
     *
     * @param userId the ID of the user associated with the notification
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the context or additional information related to the notification.
     *
     * @return the context or additional information related to the notification
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the context or additional information related to the notification.
     *
     * @param context the context or additional information related to the notification
     */
    public void setContext(String context) {
        this.context = context;
    }
}
