package be.faros.connectfour.socketcontrollers;

import be.faros.connectfour.domain.User;
import be.faros.connectfour.services.UserService;
import be.faros.connectfour.socketObjects.GamePlayed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juchtdi on 10/09/2015.
 */
@Controller
public class UserSocketController {

    @Autowired
    private UserService userService;

    @MessageMapping("/gamePlayed")
    @SendTo("/topic/gamePlayed")
    public List<User> gamePlayed(GamePlayed gamePlayed){
        User u1 = userService.findUserById(gamePlayed.getUserId1());
        User u2 = userService.findUserById(gamePlayed.getUserId2());
        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        u1.setPoints(new Double(Math.random() * 100 + 1000).intValue());
        u2.setPoints(new Double(Math.random()*100 + 1000).intValue());
        return userList;
    }
}
