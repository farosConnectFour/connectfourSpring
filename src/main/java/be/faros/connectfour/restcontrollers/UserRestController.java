package be.faros.connectfour.restcontrollers;

import be.faros.connectfour.domain.User;
import be.faros.connectfour.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by juchtdi on 9/09/2015.
 */
@RestController
@RequestMapping("/api/")
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.findAll();
    }
}
