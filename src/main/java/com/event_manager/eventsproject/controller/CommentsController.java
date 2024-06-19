package com.event_manager.eventsproject.controller;

import com.event_manager.eventsproject.entity.Comments;
import com.event_manager.eventsproject.entity.Users;
import com.event_manager.eventsproject.repository.CommentsRepository;
import com.event_manager.eventsproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Controller class for handling operations related to comments.
 */
@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private UsersRepository usersRepository;

    /**
     * Retrieves all comments.
     * @return ResponseEntity containing a list of all comments.
     */
    @GetMapping("")
    public ResponseEntity<List<Comments>> getAllComments(){
        return new ResponseEntity<>(this.commentsRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Retrieves comments associated with a specific event.
     * @param id The ID of the event to retrieve comments for.
     * @return ResponseEntity containing a list of comments associated with the event.
     */
    @GetMapping("/events/{id}")
    public ResponseEntity<List<Comments>> getAnEventComments(@PathVariable("id") Long id){
        List<Comments> commentsList = this.commentsRepository.findAllEventsById(id)
                .stream()
                .map((item)->{
                    Optional<Users> users = this.usersRepository.findById(item.getUserId());
                    if(users.isPresent()){
                        item.setUsername(users.get().getUsername());
                    }
                    return item;
                }).toList();

        return new ResponseEntity<>(commentsList,HttpStatus.OK);
    }

    /**
     * Saves a new comment.
     * @param comments The Comments object containing the comment details to be saved.
     * @return ResponseEntity indicating success or failure of the save operation.
     *         Returns 200 OK if successful, or 400 BAD REQUEST if there's an issue during save.
     */
    @PostMapping("")
    public ResponseEntity<Void> saveComment(@RequestBody Comments comments){
        try{
            this.commentsRepository.save(comments);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
