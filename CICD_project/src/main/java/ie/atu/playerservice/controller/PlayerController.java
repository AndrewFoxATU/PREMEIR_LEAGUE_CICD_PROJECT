package ie.atu.playerservice.controller;

import ie.atu.playerservice.model.Player;
import ie.atu.playerservice.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8002")  // Allow requests from frontend URL
@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/{clubName}")
    public List<Player> getPlayersByClub(@PathVariable String clubName) {
        return service.getPlayersByClub(clubName);
    }


    @GetMapping("/id/{playerId}")
    public Optional<Player> getPlayerById(@PathVariable Long playerId) { return service.getPlayerById(playerId); }
}
