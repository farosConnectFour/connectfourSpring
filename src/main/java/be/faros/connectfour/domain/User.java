package be.faros.connectfour.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by juchtdi on 9/09/2015.
 */

@Table(name = "users")
@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue
    private long userId;
    private String name;
    private int points;

    public User(){

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
