package at.ac.tuwien.dp.datascience.domain.repository;

import at.ac.tuwien.dp.datascience.domain.entity.Population;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by christoph on 16.05.17.
 */
public interface PopulationRepository extends MongoRepository<Population, Integer> {
}
