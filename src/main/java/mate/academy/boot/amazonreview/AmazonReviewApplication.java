package mate.academy.boot.amazonreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class AmazonReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonReviewApplication.class, args);
    }

}
