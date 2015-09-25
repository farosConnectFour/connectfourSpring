package be.faros.connectfour.dto;

import be.faros.connectfour.domain.Game;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

/**
 * Created by juchtdi on 14/09/2015.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GameDTO implements Serializable {

    private long gameId;
    private String player1;
    private String player2;
    private boolean rated;
    private String winner;

    public GameDTO(Game game){
        this.gameId = game.getGameId();
        this.player1 = game.getPlayer1().getName();
        this.player2 = game.getPlayer2().getName();
        this.rated = game.isRated();
        if(game.getWinner() != null){
            this.winner = game.getWinner().getName();
        }

    }
    public GameDTO(){

    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public boolean isRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    private void lol(){

    }
}
