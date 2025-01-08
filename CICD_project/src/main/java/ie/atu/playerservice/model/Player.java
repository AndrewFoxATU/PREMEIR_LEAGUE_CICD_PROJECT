package ie.atu.playerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Player {

    @Id
    private Long id;


    private String web_name;
    private String position; // MID, FWD, DEF, GKP
    private String team;
    private String news;

    private int assists;
    private int yellow_cards;
    private int own_goals;
    private int goals_scored;
    private int goals_conceded;
    private int clean_sheets;
    private int minutes;
    private int starts;
    private int red_cards;
    private double expected_goals_per_90;
    private double expected_assists_per_90;
    private double expected_goal_involvements_per_90;
    private double ict_index;


}
