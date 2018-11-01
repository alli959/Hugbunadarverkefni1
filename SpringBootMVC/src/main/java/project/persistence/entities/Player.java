package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String playerPos;
    //private Team<Id> teamId;
    //private Player<Stats> PlayerStats


    public Player() {

    }

    public Player(Long id, String name, String playerPos ) {
        this.id = id;
        this.name = name;
        this.playerPos = playerPos;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) { this.name = name;}

    public String getPlayerPos() { return playerPos;}

    public void setPlayerPos(String playerPos) { this.playerPos = playerPos;}


    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Player[name=%s, playerPos=%s]",
                name,playerPos);
    }


}


