package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Game;

import java.util.List;


public interface GameRepository extends JpaRepository<Game, Long> {

    Game save(Game game);

    void delete(Game game);

    List<Game> findAll();

    @Query(value = "Select g FROM Game g WHERE g.playerId = ?1")
    Game findByPlayerId(Long playerId);


    @Query(value = "Select g From Game g WHERE g.isBench = true")
    List<Game> getBench();

    @Query(value = "Select g From Game g WHERE g.isBench = false")
    List<Game> getPlaying();



}
