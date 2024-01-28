package mk.ukim.finki.dians;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ServletComponentScan
public class FineWineApplication {

    public static final String AUTH_MICROSERVICE_BASE_URL = "http://localhost:8080/auth";
    public static void main(String[] args) {
        SpringApplication.run(FineWineApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
