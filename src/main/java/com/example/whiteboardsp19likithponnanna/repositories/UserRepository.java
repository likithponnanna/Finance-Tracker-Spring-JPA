package com.example.whiteboardsp19likithponnanna.repositories;
import com.example.whiteboardsp19likithponnanna.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository
        extends CrudRepository<User, Integer> {
    @Query("SELECT user from User user WHERE user.username=:username AND user.password=:password")
    public List<User> findUserByUsername (@Param("username") String username, @Param("password") String password);

}