package be.faros.connectfour.services;

import be.faros.connectfour.domain.User;
import be.faros.connectfour.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by juchtdi on 9/09/2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id){
        return userRepository.findOne(id);
    }
}
