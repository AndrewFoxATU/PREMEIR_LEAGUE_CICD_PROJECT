package ie.atu.playerranking;

import ie.atu.playerservice.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerRankingService {
    private final PlayerClient playerClient;

    public PlayerRankingService(PlayerClient playerClient) {
        this.playerClient = playerClient;
    }

    public List<Player> getPlayersRankedByStat(String stat) {
        List<Player> players = playerClient.getAllPlayers();

        players = players.stream().filter(player -> {
            switch (stat) {
                case "goals_scored":
                    return player.getGoals_scored() > 0;
                case "assists":
                    return player.getAssists() > 0;
                case "yellow_cards":
                    return player.getYellow_cards() > 0;
                case "own_goals":
                    return player.getOwn_goals() > 0;
                case "goals_conceded":
                    return player.getGoals_conceded() > 0;
                case "clean_sheets":
                    return player.getClean_sheets() > 0;
                case "minutes":
                    return player.getMinutes() > 0;
                case "starts":
                    return player.getStarts() > 0;
                case "red_cards":
                    return player.getRed_cards() > 0;
                case "expected_goals_per_90":
                    return player.getExpected_goals_per_90() > 0;
                case "expected_assists_per_90":
                    return player.getExpected_assists_per_90() > 0;
                case "expected_goal_involvements_per_90":
                    return player.getExpected_goal_involvements_per_90() > 0;
                case "ict_index":
                    return player.getIct_index() > 0;
                default:
                    throw new IllegalArgumentException("Invalid stat: " + stat);
            }
        }).collect(Collectors.toList());

        players.sort((a, b) -> {
            switch (stat) {
                case "goals_scored":
                    return Integer.compare(b.getGoals_scored(), a.getGoals_scored());
                case "assists":
                    return Integer.compare(b.getAssists(), a.getAssists());
                case "yellow_cards":
                    return Integer.compare(b.getYellow_cards(), a.getYellow_cards());
                case "own_goals":
                    return Integer.compare(b.getOwn_goals(), a.getOwn_goals());
                case "goals_conceded":
                    return Integer.compare(b.getGoals_conceded(), a.getGoals_conceded());
                case "clean_sheets":
                    return Integer.compare(b.getClean_sheets(), a.getClean_sheets());
                case "minutes":
                    return Integer.compare(b.getMinutes(), a.getMinutes());
                case "starts":
                    return Integer.compare(b.getStarts(), a.getStarts());
                case "red_cards":
                    return Integer.compare(b.getRed_cards(), a.getRed_cards());
                case "expected_goals_per_90":
                    return Double.compare(b.getExpected_goals_per_90(), a.getExpected_goals_per_90());
                case "expected_assists_per_90":
                    return Double.compare(b.getExpected_assists_per_90(), a.getExpected_assists_per_90());
                case "expected_goal_involvements_per_90":
                    return Double.compare(b.getExpected_goal_involvements_per_90(), a.getExpected_goal_involvements_per_90());
                case "ict_index":
                    return Double.compare(b.getIct_index(), a.getIct_index());
                default:
                    throw new IllegalArgumentException("Invalid stat: " + stat);
            }
        });

        return players;
    }
}
