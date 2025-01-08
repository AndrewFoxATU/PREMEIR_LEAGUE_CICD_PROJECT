package ie.atu.playerranking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PlayerRankingApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlayerRankingApplication.class, args);
	}
}
