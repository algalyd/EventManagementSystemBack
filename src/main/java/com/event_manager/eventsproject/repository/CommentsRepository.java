package com.event_manager.eventsproject.repository;

import com.event_manager.eventsproject.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link Comments} entity.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations for the Comments entity.
 * It also defines custom query methods for finding comments by user ID, event ID, and both user ID and event ID.
 * </p>
 */
@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

    /**
     * Finds all comments made by a specific user.
     * <p>
     * This method retrieves all comments associated with the provided user ID.
     * </p>
     *
     * @param userId the ID of the user whose comments are to be retrieved
     * @return a list of {@link Comments} associated with the specified user ID
     */
    List<Comments> findByUserId(Long userId);

    /**
     * Finds all comments for a specific event by its ID.
     * <p>
     * This method uses a native query to find all comments associated with the provided event ID.
     * </p>
     *
     * @param eventId the ID of the event whose comments are to be retrieved
     * @return a list of {@link Comments} associated with the specified event ID
     */
    @Query(value = "SELECT * FROM comments where event_id = :eventId",nativeQuery = true)
    List<Comments> findAllEventsById(@Param("eventId") Long eventId);

    /**
     * Finds comments by both user ID and event ID.
     * <p>
     * This method retrieves all comments that match the provided user ID and event ID.
     * </p>
     *
     * @param userId the ID of the user
     * @param eventId the ID of the event
     * @return a list of {@link Comments} that match the specified user ID and event ID
     */
    List<Comments> findByUserIdAndEventId(Long userId, Long eventId);
}


