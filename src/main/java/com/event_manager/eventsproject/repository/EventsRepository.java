package com.event_manager.eventsproject.repository;
import com.event_manager.eventsproject.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Events} entity.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations for the Events entity.
 * By extending JpaRepository, this interface inherits several methods for working with Events persistence,
 * including methods for saving, deleting, and finding Events entities.
 * </p>
 */
@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {
}
