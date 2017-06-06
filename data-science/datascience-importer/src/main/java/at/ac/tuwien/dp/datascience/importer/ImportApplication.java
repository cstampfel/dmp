package at.ac.tuwien.dp.datascience.importer;

import at.ac.tuwien.dp.datascience.domain.configuration.DomainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by christoph on 16.05.17.
 */
@SpringBootApplication
@Import(DomainConfiguration.class)
public class ImportApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImportApplication.class, args);
    }
}
