package be.faros.connectfour.restcontrollers;

import be.faros.connectfour.domain.Game;
import be.faros.connectfour.domain.User;
import be.faros.connectfour.dto.GameDTO;
import be.faros.connectfour.services.GameService;
import be.faros.connectfour.socketObjects.GamePlayed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by juchtdi on 14/09/2015.
 */
@RestController
@RequestMapping("/api/games")
public class GameRestController {

    private final String PASSWORD = "HAHALOLHAHA";

    @Autowired
    private GameService gameService;

    @Autowired
    private SimpMessagingTemplate template;


    @RequestMapping(method = RequestMethod.GET)
    public List<GameDTO> get3LatestGames(){
        List<Game> games = gameService.find3LastGames();
        return games.stream().map(g -> new GameDTO(g)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void gamePlayed(@RequestBody GamePlayed gamePlayed){
        if(gamePlayed.getPassword().equals(PASSWORD)){
            Game game = gameService.findGameById(gamePlayed.getGameId());
            this.template.convertAndSend("/topic/lastGame", new GameDTO(game));

            User u1 = game.getPlayer1();
            User u2 = game.getPlayer2();
            List<User> userList = Arrays.asList(u1, u2);

            this.template.convertAndSend("/topic/playerChanges", userList);
        }
    }
}
