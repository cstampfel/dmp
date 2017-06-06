package at.ac.tuwien.dp.datascience.domain.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by christoph on 17.05.17.
 */
@ComponentScan("at.ac.tuwien.dp.datascience.domain")
@EnableMongoRepositories("at.ac.tuwien.dp.datascience.domain.repository")
public class DomainConfiguration {
}
