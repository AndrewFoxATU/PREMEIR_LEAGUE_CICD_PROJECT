package ie.atu.playerservice.repository;

import ie.atu.playerservice.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeam(String team);
}
