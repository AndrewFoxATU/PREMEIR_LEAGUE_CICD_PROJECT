package ie.atu.playerservice.util;

import ie.atu.playerservice.model.Player;
import ie.atu.playerservice.repository.PlayerRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.Reader;

@Component
public class CSVImporter {
    private final PlayerRepository playerRepository;

    public CSVImporter(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostConstruct
    public void importPlayers() {
        try {
            // Path to the CSV file
            Reader reader = new FileReader("CICD_project/src/main/resources/players.csv");
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            for (CSVRecord record : parser) {
                Player player = new Player();
                player.setId(Long.parseLong(record.get("id")));
                player.setWeb_name(record.get("name"));
                player.setPosition(record.get("position"));
                player.setTeam(record.get("team"));
                player.setNews(record.get("news"));
                player.setAssists(Integer.parseInt(record.get("assists")));
                player.setYellow_cards(Integer.parseInt(record.get("yellow_cards")));
                player.setOwn_goals(Integer.parseInt(record.get("own_goals")));
                player.setGoals_scored(Integer.parseInt(record.get("goals_scored")));
                player.setGoals_conceded(Integer.parseInt(record.get("goals_conceded")));
                player.setClean_sheets(Integer.parseInt(record.get("clean_sheets")));
                player.setMinutes(Integer.parseInt(record.get("minutes")));
                player.setStarts(Integer.parseInt(record.get("starts")));
                player.setRed_cards(Integer.parseInt(record.get("red_cards")));
                player.setExpected_goals_per_90(Double.parseDouble(record.get("expected_goals_per_90")));
                player.setExpected_assists_per_90(Double.parseDouble(record.get("expected_assists_per_90")));
                player.setExpected_goal_involvements_per_90(Double.parseDouble(record.get("expected_goal_involvements_per_90")));
                player.setIct_index(Double.parseDouble(record.get("ict_index")));

                if (!playerRepository.existsById(player.getId())) {
                    playerRepository.save(player);
                }
            }

            parser.close();
            System.out.println("Player data imported successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
