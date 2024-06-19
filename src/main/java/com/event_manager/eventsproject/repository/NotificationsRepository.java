package com.event_manager.eventsproject.repository;

import com.event_manager.eventsproject.entity.Invitations;
import com.event_manager.eventsproject.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link Notifications} entity.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations for the Notifications entity.
 * It also defines custom query methods for finding notifications by user ID and for retrieving notifications based on specific contexts.
 * </p>
 */
@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {

    /**
     * Finds all notifications for a specific user by their user ID.
     * <p>
     * This method uses a JPA query to retrieve all notifications associated with the specified user ID.
     * </p>
     *
     * @param userId the ID of the user whose notifications are to be retrieved
     * @return a list of {@link Notifications} associated with the specified user ID
     */
    List<Notifications> findByUserId(Long userId);

    /**
     * Retrieves all notifications that match either of the specified contexts.
     * <p>
     * This method uses a native query to find notifications where the context matches either of the provided contexts.
     * </p>
     *
     * @param context1 the first context to match notifications against
     * @param context2 the second context to match notifications against
     * @return a list of {@link Notifications} that match either of the specified contexts
     */
    @Query(value = "SELECT * FROM notifications where context = :context1 or context = :context2",nativeQuery = true)
    List<Notifications> getAllUsersNotifications(@Param("context1") String context1,@Param("context2") String context2);
}


