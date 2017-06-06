package at.ac.tuwien.dp.datascience.web;

import at.ac.tuwien.dp.datascience.domain.configuration.DomainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by christoph on 17.05.17.
 */
@SpringBootApplication
@Import(DomainConfiguration.class)
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
