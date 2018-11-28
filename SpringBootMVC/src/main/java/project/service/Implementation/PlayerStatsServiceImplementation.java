package project.service.Implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.PlayerStats;
import project.persistence.repositories.PlayerStatsRepository;
import project.service.PlayerStatsService;

import java.util.Collections;
import java.util.List;

public class PlayerStatsServiceImplementation implements PlayerStatsService {
    @Override
    public PlayerStats save(PlayerStats player) {
        return null;
    }

    @Override
    public void delete(PlayerStats player) {

    }

    @Override
    public List<PlayerStats> findAll() {
        return null;
    }

    @Override
    public List<PlayerStats> findAllReverseOrder() {
        return null;
    }

    @Override
    public PlayerStats findOne(Long id) {
        return null;
    }

    @Override
    public List<PlayerStats> findByName(String name) {
        return null;
    }

    @Override
    public List<PlayerStats> findLargestId() {
        return null;
    }

    @Override
    public List<PlayerStats> countPlayersInTeam(Long teamId) {
        return null;
    }

    @Override
    public List<PlayerStats> findPlayersInTeamReverseOrder(Long teamId) {
        return null;
    }
}
