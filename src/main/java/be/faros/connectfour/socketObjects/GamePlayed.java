package be.faros.connectfour.socketObjects;

import java.io.Serializable;

/**
 * Created by juchtdi on 9/09/2015.
 */
public class GamePlayed implements Serializable{
    private long gameId;

    public GamePlayed(){

    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }
}

