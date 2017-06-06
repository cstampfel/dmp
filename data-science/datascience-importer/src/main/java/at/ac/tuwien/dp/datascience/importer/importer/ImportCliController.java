package at.ac.tuwien.dp.datascience.importer.importer;

import at.ac.tuwien.dp.datascience.domain.entity.Population;
import at.ac.tuwien.dp.datascience.domain.repository.PopulationRepository;
import at.ac.tuwien.dp.datascience.importer.csv.PopulationParser;
import at.ac.tuwien.dp.datascience.importer.csv.StateParser;
import at.ac.tuwien.dp.datascience.importer.data.StateDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by christoph on 16.05.17.
 */
@Controller
public class ImportCliController implements CommandLineRunner {
    @Autowired
    private StateParser stateParser;

    @Autowired
    private PopulationRepository populationRepository;

    @Override
    public void run(String... args) throws Exception {
        StateDictionary stateDictionary = stateParser.parse();
        PopulationParser populationParser = new PopulationParser(stateDictionary);
        List<Population> populations = populationParser.parse();

        int i = 0;
        for(Population population : populations) {
            population.setId(i++);
            populationRepository.save(population);
        }
    }
}
