package be.faros.connectfour.services;

import be.faros.connectfour.domain.Game;
import be.faros.connectfour.dto.GameDTO;

import java.util.List;

/**
 * Created by juchtdi on 14/09/2015.
 */
public interface GameService {
    List<Game> find5LastGames();
    Game findGameById(long gameId);
}
