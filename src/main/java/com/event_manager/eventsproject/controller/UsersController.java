package com.event_manager.eventsproject.controller;

import com.event_manager.eventsproject.dto.LoginInfo;
import com.event_manager.eventsproject.dto.UsersDto;
import com.event_manager.eventsproject.entity.Users;
import com.event_manager.eventsproject.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller class handling HTTP requests related to users.
 * <p>
 * This controller manages CRUD operations for users including retrieval, creation, update, and deletion.
 * It provides endpoints for fetching all users, fetching a user by ID, creating a new user, logging in a user,
 * updating an existing user, and deleting a user.
 * </p>
 */
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * Retrieves all users from the database.
     *
     * @return a list of all users
     */
    @GetMapping
    public List<Users> getAllUsers() {
        return this.usersService.findAll();
    }

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id the unique identifier of the user
     * @return the user with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(this.usersService.findById(id), HttpStatus.OK);
    }

    /**
     * Creates a new user.
     *
     * @param user the user object containing user details
     * @return the created user DTO if successful, or an INTERNAL_SERVER_ERROR status if creation fails
     */
    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody Users user) {
        UsersDto usersDto = this.usersService.save(user);

        if(usersDto == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(usersDto,HttpStatus.CREATED);
    }

    /**
     * Logs in a user using provided login credentials.
     *
     * @param loginInfo the login credentials (username and password)
     * @return the logged-in user DTO if successful, or a NOT_FOUND status if login fails
     */
    @PostMapping("/login")
    public ResponseEntity<UsersDto> loginUser(@RequestBody LoginInfo loginInfo){
        UsersDto usersDto = usersService.loginUser(loginInfo);
        if(usersDto == null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(usersDto,HttpStatus.OK);
    }

    /**
     * Updates an existing user's details.
     *
     * @param id          the unique identifier of the user to update
     * @param userDetails the updated user details
     * @return the updated user DTO if successful
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable Long id, @RequestBody Users userDetails) {
        Users users = this.usersService.findById(id);
        users.setEmail(userDetails.getEmail());
        users.setUsername(userDetails.getUsername());
        users.setPassword(userDetails.getPassword());

        return new ResponseEntity<>(this.usersService.save(users),HttpStatus.OK);
    }

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id the unique identifier of the user to delete
     * @return a NO_CONTENT status upon successful deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        this.usersService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
