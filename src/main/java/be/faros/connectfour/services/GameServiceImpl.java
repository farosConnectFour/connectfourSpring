package be.faros.connectfour.services;

import be.faros.connectfour.domain.Game;
import be.faros.connectfour.dto.GameDTO;
import be.faros.connectfour.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by juchtdi on 14/09/2015.
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game findGameById(long gameId){
        return gameRepository.findOne(gameId);
    }

    @Override
    public List<Game> find5LastGames() {
        return gameRepository.findFirst5ByOrderByGameIdDesc();
    }
}
