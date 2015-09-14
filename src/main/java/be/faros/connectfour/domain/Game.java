package be.faros.connectfour.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by juchtdi on 14/09/2015.
 */
@Table(name = "games")
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Game implements Serializable{
    @Id
    @GeneratedValue
    private long gameId;

    @ManyToOne
    @JoinColumn(name="player1")
    private User player1;
    @ManyToOne
    @JoinColumn(name="player2")
    private User player2;
    private boolean ranked;
    @ManyToOne
    @JoinColumn(name="winner")
    private User winner;

    public Game(){

    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public boolean isRanked() {
        return ranked;
    }

    public void setRanked(boolean ranked) {
        this.ranked = ranked;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }
}
