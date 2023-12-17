package mk.ukim.finki.dians;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FineWineApplication {

    public static void main(String[] args) {
        SpringApplication.run(FineWineApplication.class, args);
    }

}
