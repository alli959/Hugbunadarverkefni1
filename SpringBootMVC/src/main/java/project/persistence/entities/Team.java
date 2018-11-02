package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int teamId;
    private String name;
    private Boolean home;
    private int totalPlayers;
    //private Player[] player;


    public Team(){
    }

    public Team(int teamId, String name, Boolean home, int totalPlayers){
        this.teamId = teamId;
        this.name = name;
        this.home = home;
        this.totalPlayers = totalPlayers;
    }

    public Long getId(){ return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) {this.name = name;}

    public boolean getHome() { return home; }

    public void setHome(Boolean home) {this.home = home;}

    public int getTotalPlayers() { return totalPlayers; }

    public void setTotalPlayers(int totalPlayers) {this.totalPlayers = totalPlayers;}

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Team [teamId=%s, name=%s, home=%s, totalPlayers=%s]",
                teamId, name, home, totalPlayers);
    }
}