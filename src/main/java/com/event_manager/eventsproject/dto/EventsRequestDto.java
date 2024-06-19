package com.event_manager.eventsproject.dto;

/**
 * Data Transfer Object (DTO) representing an event request in the system.
 * <p>
 * This class includes fields such as id, name, description, location, date, time, image,
 * and status. It provides constructors, getters, and setters for these fields.
 * </p>
 */
public class EventsRequestDto {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String date;
    private String time;
    private String image;
    private String status;

    /**
     * Constructs a new EventsRequestDto with the specified id, name, description,
     * location, date, time, image, and status.
     *
     * @param id          the unique identifier of the event request
     * @param name        the name of the event request
     * @param description the description of the event request
     * @param location    the location of the event request
     * @param date        the date of the event request
     * @param time        the time of the event request
     * @param image       the image associated with the event request
     * @param status      the status of the event request
     */
    public EventsRequestDto(Long id, String name, String description, String location, String date, String time, String image, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.image = image;
        this.status = status;
    }

    /**
     * Default constructor for empty initialization.
     */
    public EventsRequestDto(){}

    /**
     * Gets the unique identifier of the event request.
     *
     * @return the unique identifier of the event request
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the event request.
     *
     * @param id the unique identifier of the event request
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the event request.
     *
     * @return the name of the event request
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the event request.
     *
     * @param name the name of the event request
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the event request.
     *
     * @return the description of the event request
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the event request.
     *
     * @param description the description of the event request
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the location of the event request.
     *
     * @return the location of the event request
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the event request.
     *
     * @param location the location of the event request
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the date of the event request.
     *
     * @return the date of the event request
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the event request.
     *
     * @param date the date of the event request
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the time of the event request.
     *
     * @return the time of the event request
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the event request.
     *
     * @param time the time of the event request
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the image associated with the event request.
     *
     * @return the image associated with the event request
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image associated with the event request.
     *
     * @param image the image associated with the event request
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the status of the event request.
     *
     * @return the status of the event request
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the event request.
     *
     * @param status the status of the event request
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
