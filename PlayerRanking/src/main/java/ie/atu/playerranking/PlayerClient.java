package ie.atu.playerranking;

import ie.atu.playerservice.model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "player-service", url = "http://localhost:8081")
public interface PlayerClient {
    @GetMapping("/api/players")
    List<Player> getAllPlayers();
}