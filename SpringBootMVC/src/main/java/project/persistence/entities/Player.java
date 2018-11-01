package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;
    private Long playerNo;
    private String playerPos;
    //private Team<Id> teamId;
    //private Player<Stats> PlayerStats


    public Player() {

    }

    public Player(String name, Long playerNo, String playerPos ) {
        this.name = name;
        this.playerNo = playerNo;
        this.playerPos = playerPos;
    }

    public Long getPlayerNo() {return playerNo;}

    public void setPlayerNo(Long playerNo) {this.playerNo = playerNo;}

    public String getName() {return name;}

    public void setName(String name) { this.name = name;}

    public String getPlayerPos() { return playerPos;}

    public void setPlayerPos(String playerPos) { this.playerPos = playerPos;}



}


