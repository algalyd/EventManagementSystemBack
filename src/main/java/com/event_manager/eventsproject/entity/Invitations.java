package com.event_manager.eventsproject.entity;

import jakarta.persistence.*;

/**
 * Entity class representing an Invitation in the system.
 * <p>
 * This class maps to the "invitations" table in the database and includes fields
 * such as id, eventId, userEmail, and status. It provides constructors, getters,
 * and setters for these fields.
 * </p>
 */
@Entity
public class Invitations {

    /**
     * Constructs a new Invitation with the specified id, eventId, userEmail, and status.
     *
     * @param id        the unique identifier of the invitation
     * @param eventId   the ID of the event associated with the invitation
     * @param userEmail the email address of the user invited
     * @param status    the status of the invitation (e.g., pending, accepted, declined)
     */
    public Invitations(Long id, Long eventId, String userEmail, String status) {
        this.id = id;
        this.userEmail = userEmail;
        this.status = status;
        this.eventId = eventId;
    }

    /**
     * Default constructor for JPA.
     */
    public Invitations(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail;
    private Long eventId;
    private String status;

    /**
     * Gets the unique identifier of the invitation.
     *
     * @return the unique identifier of the invitation
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the invitation.
     *
     * @param id the unique identifier of the invitation
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the email address of the user invited.
     *
     * @return the email address of the user invited
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the email address of the user invited.
     *
     * @param userEmail the email address of the user invited
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the status of the invitation.
     *
     * @return the status of the invitation
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status of the invitation.
     *
     * @param status the status of the invitation
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the ID of the event associated with the invitation.
     *
     * @return the ID of the event associated with the invitation
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Sets the ID of the event associated with the invitation.
     *
     * @param eventId the ID of the event associated with the invitation
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
