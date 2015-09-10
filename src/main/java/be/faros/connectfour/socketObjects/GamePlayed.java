package be.faros.connectfour.socketObjects;

import java.io.Serializable;

/**
 * Created by juchtdi on 9/09/2015.
 */
public class GamePlayed implements Serializable{
    private long userId1;
    private long userId2;

    public GamePlayed(){

    }

    public long getUserId1() {
        return userId1;
    }

    public void setUserId1(long userId1) {
        this.userId1 = userId1;
    }

    public long getUserId2() {
        return userId2;
    }

    public void setUserId2(long userId2) {
        this.userId2 = userId2;
    }
}

