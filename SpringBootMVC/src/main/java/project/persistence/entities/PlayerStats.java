package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "PlayerStats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer points;
    private Integer rebounds;
    private Integer assists;
    private Integer turnovers;
    private Integer blocks;
    private Integer fouls;
    private Integer twoPmades;
    private Integer twoPmisses;
    private Integer threePmades;
    private Integer threePmisses;
    private Integer ftMades;
    private Integer ftMisses;


    public PlayerStats() {
    }

    public PlayerStats(Integer points, Integer rebounds, Integer assists, Integer turnovers, Integer blocks, Integer fouls, Integer twoPmades, Integer twoPmisses, Integer threePmades, Integer threePmisses, Integer ftMades, Integer ftMisses) {
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.turnovers = turnovers;
        this.blocks = blocks;
        this.fouls = fouls;
        this.twoPmades = twoPmades;
        this.twoPmisses = twoPmisses;
        this.threePmades = threePmades;
        this.threePmisses = threePmisses;
        this.ftMades = ftMades;
        this.ftMisses = ftMisses;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getRebounds() {
        return rebounds;
    }

    public void setRebounds(Integer rebounds) {
        this.rebounds = rebounds;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(Integer turnovers) {
        this.turnovers = turnovers;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getTwoPmades() {
        return twoPmades;
    }

    public void setTwoPmades(Integer twoPmades) {
        this.twoPmades = twoPmades;
    }

    public Integer getTwoPmisses() {
        return twoPmisses;
    }

    public void setTwoPmisses(Integer twoPmisses) {
        this.twoPmisses = twoPmisses;
    }

    public Integer getThreePmades() {
        return threePmades;
    }

    public void setThreePmades(Integer threePmades) {
        this.threePmades = threePmades;
    }

    public Integer getThreePmisses() {
        return threePmisses;
    }

    public void setThreePmisses(Integer threePmisses) {
        this.threePmisses = threePmisses;
    }

    public Integer getFtMades() {
        return ftMades;
    }

    public void setFtMades(Integer ftMades) {
        this.ftMades = ftMades;
    }

    public Integer getFtMisses() {
        return ftMisses;
    }

    public void setFtMisses(Integer ftMisses) {
        this.ftMisses = ftMisses;
    }

}
