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

    @MessageMapping("/gamePlayed")
    @SendTo("/topic/gamePlayed")
    public void gamePlayed(GamePlayed gamePlayed){
        Game game = gameService.findGameById(gamePlayed.getGameId());
        this.template.convertAndSend("/topic/lastGame", new GameDTO(game));

        User u1 = game.getPlayer1();
        User u2 = game.getPlayer2();
        List<User> userList = Arrays.asList(u1, u2);
        //TODO REMOVE
        u1.setPoints(new Double(Math.random() * 100 + 1000).intValue());
        u2.setPoints(new Double(Math.random() * 100 + 1000).intValue());
        //END REMOVE
        this.template.convertAndSend("/topic/playerChanges", userList);
    }
}
