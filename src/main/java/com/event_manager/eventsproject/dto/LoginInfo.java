package com.event_manager.eventsproject.dto;

/**
 * A record representing login credentials for authentication.
 * <p>
 * This record includes fields for username and password, used for user authentication purposes.
 * </p>
 */
public record LoginInfo(String username, String password) {
}
