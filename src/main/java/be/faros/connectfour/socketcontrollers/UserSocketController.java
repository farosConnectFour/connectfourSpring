package be.faros.connectfour.socketcontrollers;

import be.faros.connectfour.domain.Game;
import be.faros.connectfour.domain.User;
import be.faros.connectfour.dto.GameDTO;
import be.faros.connectfour.services.GameService;
import be.faros.connectfour.services.UserService;
import be.faros.connectfour.socketObjects.GamePlayed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by juchtdi on 10/09/2015.
 */
@Controller
public class UserSocketController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/")
    public void gamePlayed(GamePlayed gamePlayed){

    }
}
