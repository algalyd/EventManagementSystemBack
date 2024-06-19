package com.event_manager.eventsproject.repository;

import com.event_manager.eventsproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Users} entity.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD operations for the Users entity.
 * It also defines custom query methods for user login and checking if a username or email already exists.
 * </p>
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * Custom query to log in a user using either username or email and password.
     * <p>
     * This method uses a native query to find a user by their username (or email) and password.
     * If a match is found, it returns the corresponding {@link Users} object.
     * </p>
     *
     * @param username the username or email of the user attempting to log in
     * @param password the password of the user attempting to log in
     * @return the {@link Users} object if the username/email and password match, otherwise null
     */
    @Query(value = "SELECT * FROM users WHERE (username = :username or email = :username) and password = :password",nativeQuery = true)
    Users loginUser(@Param("username") String username,  @Param("password") String password);

    /**
     * Custom query to check if a username or email already exists in the database.
     * <p>
     * This method uses a native query to find a user by their username or email.
     * If a match is found, it returns the corresponding {@link Users} object.
     * </p>
     *
     * @param username the username to check for existence
     * @param email the email to check for existence
     * @return the {@link Users} object if the username or email exists, otherwise null
     */
    @Query(value = "SELECT * FROM users WHERE username = :username or email = :email",nativeQuery = true)
    Users usernameOrEmailExist(@Param("username") String username, @Param("email") String email);

    /**
     * Finds a user by their email.
     * <p>
     * This method uses a JPA query to find a user by their email.
     * If a match is found, it returns the corresponding {@link Users} object.
     * </p>
     *
     * @param email the email of the user to find
     * @return the {@link Users} object if a user with the specified email exists, otherwise null
     */
    Users findByEmail(String email);
}


