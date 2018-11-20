package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "PlayerStats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;
    private Long points;
    private Long rebounds;
    private Long assists;
    private Long turnovers;
    private Long blocks;
    private Long fouls;
    private Long twoPmades;
    private Long twoPmisses;
    private Long threePmades;
    private Long threePmisses;
    private Long ftMades;
    private Long ftMisses;


    public PlayerStats() {
    }

    public PlayerStats(Long id, Long playerId, Long points, Long rebounds, Long assists, Long turnovers, Long blocks, Long fouls, Long twoPmades, Long twoPmisses, Long threePmades, Long threePmisses, Long ftMades, Long ftMisses) {
        this.id = id;
        this.playerId = playerId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Long getRebounds() {
        return rebounds;
    }

    public void setRebounds(Long rebounds) {
        this.rebounds = rebounds;
    }

    public Long getAssists() {
        return assists;
    }

    public void setAssists(Long assists) {
        this.assists = assists;
    }

    public Long getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(Long turnovers) {
        this.turnovers = turnovers;
    }

    public Long getBlocks() {
        return blocks;
    }

    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    public Long getFouls() {
        return fouls;
    }

    public void setFouls(Long fouls) {
        this.fouls = fouls;
    }

    public Long getTwoPmades() {
        return twoPmades;
    }

    public void setTwoPmades(Long twoPmades) {
        this.twoPmades = twoPmades;
    }

    public Long getTwoPmisses() {
        return twoPmisses;
    }

    public void setTwoPmisses(Long twoPmisses) {
        this.twoPmisses = twoPmisses;
    }

    public Long getThreePmades() {
        return threePmades;
    }

    public void setThreePmades(Long threePmades) {
        this.threePmades = threePmades;
    }

    public Long getThreePmisses() {
        return threePmisses;
    }

    public void setThreePmisses(Long threePmisses) {
        this.threePmisses = threePmisses;
    }

    public Long getFtMades() {
        return ftMades;
    }

    public void setFtMades(Long ftMades) {
        this.ftMades = ftMades;
    }

    public Long getFtMisses() {
        return ftMisses;
    }

    public void setFtMisses(Long ftMisses) {
        this.ftMisses = ftMisses;
    }

}
