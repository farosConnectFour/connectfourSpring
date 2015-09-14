package be.faros.connectfour.restcontrollers;

import be.faros.connectfour.domain.Game;
import be.faros.connectfour.dto.GameDTO;
import be.faros.connectfour.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by juchtdi on 14/09/2015.
 */
@RestController
@RequestMapping("/api/games")
public class GameRestController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public List<GameDTO> get3LatestGames(){
        List<Game> games = gameService.find3LastGames();
        return games.stream().map(g -> new GameDTO(g)).collect(Collectors.toList());
    }
}
