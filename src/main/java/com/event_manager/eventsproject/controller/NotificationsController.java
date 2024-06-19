package com.event_manager.eventsproject.controller;

import com.event_manager.eventsproject.entity.Notifications;
import com.event_manager.eventsproject.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class handling HTTP requests related to notifications.
 * <p>
 * This controller provides endpoints for CRUD operations on notifications,
 * including fetching all notifications, fetching a notification by ID,
 * fetching notifications by user ID or specific context, saving notifications,
 * updating notifications, and deleting notifications by ID.
 * </p>
 */
@CrossOrigin
@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsRepository notificationsRepository;

    /**
     * Retrieves all notifications.
     *
     * @return a list of all notifications
     */
    @GetMapping("")
    public ResponseEntity<List<Notifications>> getAllNotifications(){
        return new ResponseEntity<>(this.notificationsRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Retrieves a notification by its ID.
     *
     * @param id the unique identifier of the notification
     * @return the notification with the specified ID if found, or a 404 NOT FOUND status if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Notifications> getOneNotification(@PathVariable("id") Long id){
        Optional<Notifications> notifications = this.notificationsRepository.findById(id);
        return notifications.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves notifications associated with a specific user ID.
     *
     * @param id the ID of the user for whom notifications are to be retrieved
     * @return a list of notifications associated with the specified user ID
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<List<Notifications>> getUsersNotification(@PathVariable("id") Long id) {
        List<Notifications> notifications = this.notificationsRepository.findByUserId(id);
        return new ResponseEntity<>(notifications,HttpStatus.OK);
    }

    /**
     * Retrieves notifications associated with a specific user email and context.
     *
     * @param email   the email of the user for whom notifications are to be retrieved
     * @param context the context or type of notifications to retrieve
     * @return a list of notifications matching the specified user email and context
     */
    @GetMapping("/users/{email}/context/{context}")
    public ResponseEntity<List<Notifications>> getAllUsersNotification(@PathVariable("email") String email,@PathVariable("context") String context) {
        List<Notifications> notifications = this.notificationsRepository.getAllUsersNotifications(email,context);
        return new ResponseEntity<>(notifications,HttpStatus.OK);
    }

    /**
     * Saves a new notification.
     *
     * @param notifications the notification object to save
     * @return a CREATED status if the notification is saved successfully, or an INTERNAL_SERVER_ERROR status if saving fails
     */
    @PostMapping("")
    public ResponseEntity<Void> saveNotification(@RequestBody Notifications notifications){
        try{
            this.notificationsRepository.save(notifications);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Saves multiple notifications.
     *
     * @param notifications a list of notification objects to save
     * @return a CREATED status if all notifications are saved successfully, or an INTERNAL_SERVER_ERROR status if saving fails
     */
    @PostMapping("/all")
    public ResponseEntity<Void> saveAllNotifications(@RequestBody List<Notifications> notifications){
        try{
            this.notificationsRepository.saveAll(notifications);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }


    /**
     * Updates an existing notification.
     *
     * @param id            the unique identifier of the notification to update
     * @param notifications the updated notification object
     * @return an OK status if the notification is updated successfully, or an INTERNAL_SERVER_ERROR status if updating fails
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNotification(@PathVariable("id") Long id, @RequestBody Notifications notifications){
        try{
            Notifications myNotif = this.notificationsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("sorry no notification found with this id: "+id));
            myNotif.setContext(notifications.getContext());
            myNotif.setMessage(notifications.getMessage());
            this.notificationsRepository.save(myNotif);

            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Deletes a notification by its ID.
     *
     * @param id the unique identifier of the notification to delete
     * @return a NO_CONTENT status upon successful deletion, or an INTERNAL_SERVER_ERROR status if deletion fails
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable("id") Long id){
        try{
            this.notificationsRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
