package project.persistence.entities;


import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;

import javax.persistence.*;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.util.List;


import static javax.persistence.GenerationType.*;


/*
    This is a huge database table for the shots, hits or miss
 */
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long playerId;
    private boolean isBench;
    private Long LeftWingThreeHit;
    private Long LeftWingThreeMiss;
    private Long RightWingThreeHit;
    private Long RightWingThreeMiss;
    private Long TopThreeHit;
    private Long TopThreeMiss;
    private Long LeftCornerThreeHit;
    private Long LeftCornerThreeMiss;
    private Long RightCornerThreeHit;
    private Long RightCornerThreeMiss;
    private Long LeftShortCornerHit;
    private Long LeftShortCornerMiss;
    private Long RightShortCornerHit;
    private Long RightShortCornerMiss;
    private Long LeftTopKeyHit;
    private Long LeftTopKeyMiss;
    private Long RightTopKeyHit;
    private Long RightTopKeyMiss;
    private Long TopKeyHit;
    private Long TopKeyMiss;
    private Long LayUpHit;
    private Long LayUpMiss;

    public Game() {

    }

    public Game(Long id, Long playerId, boolean isBench, Long  LeftWingThreeHit, Long LeftWingThreeMiss,
                Long RightWingThreeHit, Long RightWingThreeMiss, Long TopThreeHit , Long TopThreeMiss ,
                Long LeftCornerThreeHit, Long LeftCornerThreeMiss, Long RightCornerThreeHit, Long RightCornerThreeMiss,
                Long LeftShortCornerHit, Long LeftShortCornerMiss, Long RightShortCornerHit, Long RightShortCornerMiss, Long LeftTopKeyHit,
                Long LeftTopKeyMiss, Long RightTopKeyHit, Long RightTopKeyMiss, Long TopKeyHit, Long TopKeyMiss, Long LayUpHit, Long LayUpMiss) {

        this.id = id;
        this.playerId = playerId;
        this.isBench = isBench;
        this.LeftWingThreeHit = LeftWingThreeHit;
        this.LeftWingThreeMiss = LeftWingThreeMiss;
        this.RightWingThreeHit = RightWingThreeHit;
        this.RightWingThreeMiss = RightWingThreeMiss;
        this.TopThreeHit = TopThreeHit;
        this.TopThreeMiss = TopThreeMiss;
        this.LeftCornerThreeHit = LeftCornerThreeHit;
        this.LeftCornerThreeMiss = LeftCornerThreeMiss;
        this.RightCornerThreeHit = RightCornerThreeHit;
        this.RightCornerThreeMiss = RightCornerThreeMiss;
        this.LeftShortCornerHit = LeftShortCornerHit;
        this.LeftShortCornerMiss = LeftShortCornerMiss;
        this.RightShortCornerHit = RightShortCornerHit;
        this.RightShortCornerMiss = RightShortCornerMiss;
        this.LeftTopKeyHit = LeftTopKeyHit;
        this.LeftTopKeyMiss = LeftTopKeyMiss;
        this.RightTopKeyHit = RightTopKeyHit;
        this.RightTopKeyMiss = RightTopKeyMiss;
        this.TopKeyHit = TopKeyHit;
        this.TopKeyMiss = TopKeyMiss;
        this.LayUpHit = LayUpHit;
        this.LayUpMiss = LayUpMiss;

    }

    public Long getId() {
        return id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public boolean isBench() {
        return isBench;
    }

    public Long getLeftWingThreeHit() {
        return LeftWingThreeHit;
    }

    public Long getLeftWingThreeMiss() {
        return LeftWingThreeMiss;
    }

    public Long getRightWingThreeHit() {
        return RightWingThreeHit;
    }

    public Long getRightWingThreeMiss() {
        return RightWingThreeMiss;
    }

    public Long getTopThreeHit() {
        return TopThreeHit;
    }

    public Long getTopThreeMiss() {
        return TopThreeMiss;
    }

    public Long getLeftCornerThreeHit() {
        return LeftCornerThreeHit;
    }

    public Long getLeftCornerThreeMiss() {
        return LeftCornerThreeMiss;
    }

    public Long getRightCornerThreeHit() {
        return RightCornerThreeHit;
    }

    public Long getRightCornerThreeMiss() {
        return RightCornerThreeMiss;
    }

    public Long getLeftShortCornerHit() {
        return LeftShortCornerHit;
    }

    public Long getLeftShortCornerMiss() {
        return LeftShortCornerMiss;
    }

    public Long getRightShortCornerHit() {
        return RightShortCornerHit;
    }

    public Long getRightShortCornerMiss() {
        return RightShortCornerMiss;
    }

    public Long getLeftTopKeyHit() {
        return LeftTopKeyHit;
    }

    public Long getLeftTopKeyMiss() {
        return LeftTopKeyMiss;
    }

    public Long getRightTopKeyHit() {
        return RightTopKeyHit;
    }

    public Long getRightTopKeyMiss() {
        return RightTopKeyMiss;
    }

    public Long getTopKeyHit() {
        return TopKeyHit;
    }

    public Long getTopKeyMiss() {
        return TopKeyMiss;
    }

    public Long getLayUpHit() {
        return LayUpHit;
    }

    public Long getLayUpMiss() {
        return LayUpMiss;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public void setBench(boolean bench) {
        isBench = bench;
    }

    public void setLeftWingThreeHit(Long leftWingThreeHit) {
        LeftWingThreeHit = leftWingThreeHit;
    }

    public void setLeftWingThreeMiss(Long leftWingThreeMiss) {
        LeftWingThreeMiss = leftWingThreeMiss;
    }

    public void setRightWingThreeHit(Long rightWingThreeHit) {
        RightWingThreeHit = rightWingThreeHit;
    }

    public void setRightWingThreeMiss(Long rightWingThreeMiss) {
        RightWingThreeMiss = rightWingThreeMiss;
    }

    public void setTopThreeHit(Long topThreeHit) {
        TopThreeHit = topThreeHit;
    }

    public void setTopThreeMiss(Long topThreeMiss) {
        TopThreeMiss = topThreeMiss;
    }

    public void setLeftCornerThreeHit(Long leftCornerThreeHit) {
        LeftCornerThreeHit = leftCornerThreeHit;
    }

    public void setLeftCornerThreeMiss(Long leftCornerThreeMiss) {
        LeftCornerThreeMiss = leftCornerThreeMiss;
    }

    public void setRightCornerThreeHit(Long rightCornerThreeHit) {
        RightCornerThreeHit = rightCornerThreeHit;
    }

    public void setRightCornerThreeMiss(Long rightCornerThreeMiss) {
        RightCornerThreeMiss = rightCornerThreeMiss;
    }

    public void setLeftShortCornerHit(Long leftShortCornerHit) {
        LeftShortCornerHit = leftShortCornerHit;
    }

    public void setLeftShortCornerMiss(Long leftShortCornerMiss) {
        LeftShortCornerMiss = leftShortCornerMiss;
    }

    public void setRightShortCornerHit(Long rightShortCornerHit) {
        RightShortCornerHit = rightShortCornerHit;
    }

    public void setRightShortCornerMiss(Long rightShortCornerMiss) {
        RightShortCornerMiss = rightShortCornerMiss;
    }

    public void setLeftTopKeyHit(Long leftTopKeyHit) {
        LeftTopKeyHit = leftTopKeyHit;
    }

    public void setLeftTopKeyMiss(Long leftTopKeyMiss) {
        LeftTopKeyMiss = leftTopKeyMiss;
    }

    public void setRightTopKeyHit(Long rightTopKeyHit) {
        RightTopKeyHit = rightTopKeyHit;
    }

    public void setRightTopKeyMiss(Long rightTopKeyMiss) {
        RightTopKeyMiss = rightTopKeyMiss;
    }

    public void setTopKeyHit(Long topKeyHit) {
        TopKeyHit = topKeyHit;
    }

    public void setTopKeyMiss(Long topKeyMiss) {
        TopKeyMiss = topKeyMiss;
    }

    public void setLayUpHit(Long layUpHit) {
        LayUpHit = layUpHit;
    }

    public void setLayUpMiss(Long layUpMiss) {
        LayUpMiss = layUpMiss;
    }
}
