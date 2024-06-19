package com.event_manager.eventsproject.services;

import com.event_manager.eventsproject.dto.LoginInfo;
import com.event_manager.eventsproject.dto.UsersDto;
import com.event_manager.eventsproject.entity.Users;
import com.event_manager.eventsproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing user-related operations.
 * <p>
 * This service provides methods for finding, saving, and deleting users,
 * as well as logging in users. It interacts with the {@link UsersRepository}
 * to perform database operations.
 * </p>
 */
@Service
public class UsersService {


    @Autowired
    public UsersRepository usersRepository;

    /**
     * Retrieves all users from the database.
     *
     * @return a list of all {@link Users}
     */
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    /**
     * Finds a user by their ID.
     *
     * @param id the ID of the user to find
     * @return the {@link Users} object if found
     * @throws IllegalArgumentException if the user with the specified ID does not exist
     */
    public Users findById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User with id: "+id+" does not exist"));
    }

    /**
     * Saves a new user to the database.
     * <p>
     * Before saving, it checks if a user with the same username or email already exists.
     * If such a user exists, it returns null. Otherwise, it saves the user and returns
     * a {@link UsersDto} containing the user's ID, email, and username.
     * </p>
     *
     * @param user the {@link Users} object to be saved
     * @return a {@link UsersDto} if the user was successfully saved, or null if a user with the same username or email already exists
     */
    public UsersDto save(Users user) {
        Users usernameOrEmailExist  = usersRepository.usernameOrEmailExist(user.getUsername(),user.getEmail());
        if(usernameOrEmailExist != null){
            return null;
        }
        usersRepository.save(user);

        return new UsersDto(user.getId(),user.getEmail(),user.getUsername());
    }

    /**
     * Logs in a user.
     * <p>
     * This method verifies the user's credentials. If the credentials are valid,
     * it returns a {@link UsersDto} containing the user's ID, email, and username.
     * Otherwise, it returns null.
     * </p>
     *
     * @param loginInfo the {@link LoginInfo} containing the username and password
     * @return a {@link UsersDto} if the login is successful, or null if the credentials are invalid
     */
    public UsersDto loginUser(LoginInfo loginInfo){
        Users savedUser =  usersRepository.loginUser(loginInfo.username(), loginInfo.password());
        if(savedUser == null) return null;
        return new UsersDto(savedUser.getId(),savedUser.getEmail(),savedUser.getUsername());
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to be deleted
     */
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }
}
