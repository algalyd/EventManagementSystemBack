package com.event_manager.eventsproject.controller;

import com.event_manager.eventsproject.entity.Events;
import com.event_manager.eventsproject.entity.Users;
import com.event_manager.eventsproject.services.EventsService;
import com.event_manager.eventsproject.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for handling operations related to events.
 */
@CrossOrigin
@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private UsersService usersService;

    private final EventsService eventService;

    /**
     * Constructor to initialize EventsController with EventsService dependency injection.
     * @param eventService The EventsService instance used for event-related operations.
     */
    public EventsController(EventsService eventService) {
        this.eventService = eventService;
    }

    /**
     * Retrieves all events.
     * @return List of all events.
     */
    @GetMapping
    public List<Events> getAllEvents() {
        return eventService.findAll();
    }

    /**
     * Retrieves upcoming events for a specific user.
     * @param user_id The ID of the user to retrieve upcoming events for.
     * @return List of upcoming events excluding those the user is already associated with.
     */
    @GetMapping("/upcoming/{user_id}")
    public List<Events> getUpcomingEvents(@PathVariable Long user_id) {
        List<Events> eventsList = new ArrayList<>();
         eventService.findAll()
                 .forEach((item)->{
                     List<Users> users = item.getUsers().stream().filter((itm)-> itm.getId() != user_id).toList();
                     if(!users.isEmpty()){
                         eventsList.add(item);
                     }
                 });

         return eventsList;
    }

    /**
     * Retrieves an event by its ID.
     * @param id The ID of the event to retrieve.
     * @return ResponseEntity containing the event if found, or 404 NOT FOUND if no event with the given ID exists.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Events> getEventById(@PathVariable Long id) {
        Events events = eventService.findById(id);

        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    /**
     * Creates a new event.
     * @param name The name of the event.
     * @param description The description of the event.
     * @param location The location of the event.
     * @param date The date of the event.
     * @param time The time of the event.
     * @param image The image file associated with the event.
     * @param userIds The list of user IDs associated with the event.
     * @return The created event with associated details.
     * @throws IOException If there's an issue with processing the image file.
     */
    @PostMapping
    public Events createEvent(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("location") String location,
                              @RequestParam("date") String date,
                              @RequestParam("time") String time,
                              @RequestParam(value = "image") MultipartFile image,
                              @RequestParam("users") List<Long> userIds) throws IOException {
        Events event = new Events();
        event.setName(name);
        event.setDescription(description);
        event.setLocation(location);
        event.setDate(date);
        event.setTime(time);

        List<Users> users = userIds.stream()
                .map(usersService::findById)
                .collect(Collectors.toList());
        event.setUsers(users);

        return eventService.saveEventWithImage(event, image);
    }

    /**
     * Updates an existing event by its ID.
     * @param id The ID of the event to update.
     * @param name The updated name of the event.
     * @param description The updated description of the event.
     * @param location The updated location of the event.
     * @param date The updated date of the event.
     * @param time The updated time of the event.
     * @param image The updated image file associated with the event.
     * @return ResponseEntity containing the updated event if successful, or 500 INTERNAL SERVER ERROR if there's an issue during update.
     * @throws IOException If there's an issue with processing the image file.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Events> updateEvent(@PathVariable Long id,
                                             @RequestParam("name") String name,
                                             @RequestParam("description") String description,
                                             @RequestParam("location") String location,
                                             @RequestParam("date") String date,
                                             @RequestParam("time") String time,
                                             @RequestParam("image") MultipartFile image) throws IOException {
        Events event =  eventService.findById(id);
        event.setName(name);
        event.setDescription(description);
        event.setLocation(location);
        event.setDate(date);
        event.setTime(time);
        try {
            return ResponseEntity.ok().body(eventService.saveEventWithImage(event, image));
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    /**
     * Deletes an event by its ID.
     * @param id The ID of the event to delete.
     * @return ResponseEntity indicating success or failure of the delete operation.
     *         Returns 500 INTERNAL SERVER ERROR if there's an issue during delete.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        Events event = eventService.findById(id);
        try{
            eventService.deleteById(id);
            return ResponseEntity.ok().build();
        }catch(Exception e) {
            eventService.deleteById(id);
            return ResponseEntity.internalServerError().build();
        }
    }
}
