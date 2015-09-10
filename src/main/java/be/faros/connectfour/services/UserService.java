package be.faros.connectfour.services;

import be.faros.connectfour.domain.User;

import java.util.List;

/**
 * Created by juchtdi on 9/09/2015.
 */
public interface UserService {
    List<User> findAll();
    User findUserById(long id);
}
