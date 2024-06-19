package com.event_manager.eventsproject.services;

import com.event_manager.eventsproject.entity.Events;
import com.event_manager.eventsproject.repository.EventsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Service class for managing event-related operations.
 * <p>
 * This service provides methods for finding, saving, and deleting events,
 * as well as saving events with associated image files. It interacts with
 * the {@link EventsRepository} to perform database operations.
 * </p>
 */
@Service
public class EventsService {


    private final EventsRepository eventRepository;

    /**
     * Constructs an instance of {@code EventsService} with the specified {@link EventsRepository}.
     *
     * @param eventRepository the repository used to interact with the events database
     */
    public EventsService(EventsRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Retrieves all events from the database.
     *
     * @return a list of all {@link Events}
     */
    public List<Events> findAll() {
        return eventRepository.findAll();
    }

    /**
     * Finds an event by its ID.
     *
     * @param id the ID of the event to find
     * @return the {@link Events} object if found
     * @throws IllegalArgumentException if the event with the specified ID does not exist
     */
    public Events findById(Long id) {
        return eventRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Event with id: "+id+" does not exist !!!"));
    }

    /**
     * Saves a new event to the database.
     *
     * @param event the {@link Events} object to be saved
     * @return the saved {@link Events} object
     */
    public Events save(Events event) {
        return eventRepository.save(event);
    }

    /**
     * Deletes an event by its ID.
     *
     * @param id the ID of the event to be deleted
     */
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    /**
     * Saves an event along with an associated image file.
     * <p>
     * This method saves the image file to the server and sets the file path
     * in the event before saving the event to the database.
     * </p>
     *
     * @param event the {@link Events} object to be saved
     * @param image the {@link MultipartFile} representing the image file to be saved
     * @return the saved {@link Events} object with the image path set
     * @throws IOException if an I/O error occurs during file saving
     */
    public Events saveEventWithImage(Events event, MultipartFile image) throws IOException {
        // Save the image file to the server and set the file path in the event
        String imagePath = "uploads/" + image.getOriginalFilename();
        Files.createDirectories(Paths.get("uploads/"));
        Files.copy(image.getInputStream(), Paths.get(imagePath));
        event.setImage(imagePath);
        return eventRepository.save(event);
    }
}
