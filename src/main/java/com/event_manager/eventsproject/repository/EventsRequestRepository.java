package com.event_manager.eventsproject.repository;

import com.event_manager.eventsproject.entity.EventsRequest;
import com.event_manager.eventsproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link EventsRequest} entity.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations for the EventsRequest entity.
 * It also defines custom query methods for retrieving user-specific event requests and checking for the existence of specific requests.
 * </p>
 */
@Repository
public interface EventsRequestRepository extends JpaRepository<EventsRequest, Long> {

    /**
     * Retrieves all event requests made by a specific user.
     * <p>
     * This method uses a native query to find all event requests associated with the provided user ID.
     * </p>
     *
     * @param user_id the ID of the user whose event requests are to be retrieved
     * @return a list of {@link EventsRequest} associated with the specified user ID
     */
    @Query(value = "SELECT * FROM events_table WHERE user_id = :user_id",nativeQuery = true)
    List<EventsRequest> getAllUsersRequests(@Param("user_id") Long user_id);

    /**
     * Checks if a specific event request exists for a user.
     * <p>
     * This method uses a native query to find an event request that matches both the provided user ID and event ID.
     * </p>
     *
     * @param user_id the ID of the user
     * @param event_id the ID of the event
     * @return a list of {@link EventsRequest} that match the specified user ID and event ID
     */
    @Query(value = "SELECT * FROM events_table WHERE user_id = :user_id AND event_id = :event_id",nativeQuery = true)
    List<EventsRequest> requestExist(@Param("user_id") Long user_id, @Param("event_id") Long event_id);

}


