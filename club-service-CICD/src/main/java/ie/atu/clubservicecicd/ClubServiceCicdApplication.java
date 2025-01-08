package ie.atu.clubservicecicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClubServiceCicdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubServiceCicdApplication.class, args);
    }
}
