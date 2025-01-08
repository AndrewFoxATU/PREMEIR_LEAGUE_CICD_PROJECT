package ie.atu.playerservice.service;

import ie.atu.playerservice.model.Player;
import ie.atu.playerservice.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }

    public List<Player> getPlayersByClub(String clubName) {
        return repository.findByTeam(clubName);
    }


    public Optional<Player> getPlayerById(Long playerId) {
        return repository.findById(playerId);
    }
}
