package ie.atu.playerranking;

import ie.atu.playerservice.model.Player;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rankings")
@CrossOrigin(origins = "http://localhost:8002")  // Allow requests from frontend URL (CORS)
public class PlayerRankingController {
    private final PlayerRankingService rankingService;

    public PlayerRankingController(PlayerRankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping("/{stat}")
    public List<Player> getPlayersRankedByStat(@PathVariable String stat) {
        return rankingService.getPlayersRankedByStat(stat);
    }
}
