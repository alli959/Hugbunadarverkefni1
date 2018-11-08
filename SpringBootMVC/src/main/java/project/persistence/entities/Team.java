package project.persistence.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String location;



    public Team(){
    }

    public Team(Long id, String name, String location){
        this.id = id;
        this.name = name;
        this.location = location;
        //this.player = player;
    }

    public Long getId(){ return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) {this.name = name;}

    public String getlocation() { return location; }

    public void setlocation(String location) {this.location = location;}


    //public Player getPlayer() {return player;}

    //public void setPlayer(Player player) {this.player = player;}
    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Team [id=%s, name=%s, location=%s]",
                id, name, location);
    }

}
