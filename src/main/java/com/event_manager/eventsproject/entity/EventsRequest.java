package com.event_manager.eventsproject.entity;
import jakarta.persistence.*;

/**
 * Entity class representing an EventsRequest in the system.
 * <p>
 * This class maps to the "events_table" table in the database and includes fields
 * such as id, event_id, user_id, and status. It provides constructors, getters,
 * and setters for these fields.
 * </p>
 */
@Entity
@Table(name = "events_table")
public class EventsRequest {

    /**
     * Constructs a new EventsRequest with the specified id, event_id, user_id, and status.
     *
     * @param id       the unique identifier of the EventsRequest
     * @param event_id the ID of the event associated with the request
     * @param user_id  the ID of the user associated with the request
     * @param status   the status of the request (e.g., pending, accepted, declined)
     */
    public EventsRequest(Long id, Long event_id, Long user_id, String status) {
        this.id = id;
        this.event_id = event_id;
        this.user_id = user_id;
        this.status = status;
    }

    /**
     * Default constructor for JPA.
     */
    public EventsRequest() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long event_id;
    private Long user_id;
    private String status;

    /**
     * Gets the unique identifier of the EventsRequest.
     *
     * @return the unique identifier of the EventsRequest
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the EventsRequest.
     *
     * @param id the unique identifier of the EventsRequest
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the ID of the event associated with the request.
     *
     * @return the ID of the event associated with the request
     */
    public Long getEvent_id() {
        return event_id;
    }

    /**
     * Sets the ID of the event associated with the request.
     *
     * @param event_id the ID of the event associated with the request
     */
    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    /**
     * Gets the status of the EventsRequest.
     *
     * @return the status of the EventsRequest
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the EventsRequest.
     *
     * @param status the status of the EventsRequest
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the ID of the user associated with the request.
     *
     * @return the ID of the user associated with the request
     */
    public Long getUser_id() {
        return user_id;
    }

    /**
     * Sets the ID of the user associated with the request.
     *
     * @param user_id the ID of the user associated with the request
     */
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
