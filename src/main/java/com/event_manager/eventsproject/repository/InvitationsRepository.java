package com.event_manager.eventsproject.repository;

import com.event_manager.eventsproject.entity.Invitations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link Invitations} entity.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations for the Invitations entity.
 * It also defines custom query methods for finding invitations by status, user email, and event ID.
 * </p>
 */
@Repository
public interface InvitationsRepository extends JpaRepository<Invitations, Long> {

    /**
     * Finds all invitations with the specified status.
     * <p>
     * This method retrieves all invitations that match the provided status.
     * </p>
     *
     * @param status the status of the invitations to retrieve
     * @return a list of {@link Invitations} that match the specified status
     */
    List<Invitations> findByStatus(String status);

    /**
     * Finds all invitations for a specific user by their email.
     * <p>
     * This method retrieves all invitations associated with the provided user email.
     * </p>
     *
     * @param email the email of the user whose invitations are to be retrieved
     * @return a list of {@link Invitations} associated with the specified user email
     */
    List<Invitations> findByUserEmail(String email);

    /**
     * Finds all invitations for a specific event by its ID and status.
     * <p>
     * This method retrieves all invitations for the specified event ID that match the provided status.
     * </p>
     *
     * @param eventId the ID of the event
     * @param status the status of the invitations to retrieve
     * @return a list of {@link Invitations} for the specified event ID that match the specified status
     */
    List<Invitations> findByEventIdAndStatus(Long eventId, String status);

    /**
     * Finds an invitation by user email and event ID.
     * <p>
     * This method retrieves the invitation associated with the provided user email and event ID.
     * </p>
     *
     * @param userEmail the email of the user
     * @param eventId the ID of the event
     * @return the {@link Invitations} associated with the specified user email and event ID
     */
    Invitations findByUserEmailAndEventId(String userEmail, Long eventId);
}


