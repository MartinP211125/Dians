package mk.ukim.finki.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AuthMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthMicroServiceApplication.class, args);
    }

}
