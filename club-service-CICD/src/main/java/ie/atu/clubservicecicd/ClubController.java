package ie.atu.clubservicecicd;

import ie.atu.playerservice.model.Player;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8002")  // Allow requests from frontend URL (CORS)
@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    private final PlayerClient playerClient;

    public ClubController(PlayerClient playerClient) {
        this.playerClient = playerClient;
    }

    @GetMapping("/{clubName}")
    public List<Player> getPlayersByClub(@PathVariable String clubName) {
        return playerClient.getPlayersByClub(clubName);
    }
}

