package be.faros.connectfour.dto;

import be.faros.connectfour.domain.Game;

import java.io.Serializable;

/**
 * Created by juchtdi on 14/09/2015.
 */
public class GameDTO implements Serializable {

    private long gameId;
    private String player1;
    private String player2;
    private boolean ranked;
    private String winner;

    public GameDTO(Game game){
        this.gameId = game.getGameId();
        this.player1 = game.getPlayer1().getName();
        this.player2 = game.getPlayer1().getName();
        this.ranked = game.isRanked();
        this.winner = game.getWinner().getName();
    }
}
