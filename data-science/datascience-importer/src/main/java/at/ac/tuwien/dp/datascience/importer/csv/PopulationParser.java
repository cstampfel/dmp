package at.ac.tuwien.dp.datascience.importer.csv;

import at.ac.tuwien.dp.datascience.domain.entity.Population;
import at.ac.tuwien.dp.datascience.domain.entity.State;
import at.ac.tuwien.dp.datascience.domain.entity.StatePopulation;
import at.ac.tuwien.dp.datascience.importer.data.StateDictionary;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by christoph on 16.05.17.
 */
public class PopulationParser {
    private static final CSVFormat CSV_FORMAT = CSVFormat.EXCEL.withDelimiter(';');

    private final StateDictionary stateDictionary;

    public PopulationParser(StateDictionary stateDictionary) {
        this.stateDictionary = stateDictionary;
    }

    public List<Population> parse() throws URISyntaxException, IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("OGD_f1197_Bev_Jahresdurchschn_1.csv")) {
            List<String> lines = IOUtils.readLines(inputStream, "UTF-8");
            String content = lines.stream().skip(1).collect(Collectors.joining("\n"));

            Map<Integer, Population> map = new HashMap<>();

            for (CSVRecord csvRecord : CSVParser.parse(content, CSV_FORMAT)) {
                String rawYear = csvRecord.get(0);
                int year = Integer.valueOf(rawYear.substring(rawYear.lastIndexOf("-") + 1));
                updatePopulation(map, year, csvRecord);
            }

            return new ArrayList<>(map.values());
        }
    }

    private void updatePopulation(Map<Integer, Population> map, int year, CSVRecord csvRecord) {
        Population population = getOrCreatePopulation(map, year);
        String stateCode = csvRecord.get(1);
        State state = stateDictionary.get(stateCode);

        if(state != null) {
            StatePopulation statePopulation = getOrCreateStatePopulation(population, state);
            String sex = csvRecord.get(2);
            int amount = Integer.valueOf(csvRecord.get(3));

            if(isMale(sex)) {
                statePopulation.setMen(amount);
            } else if(isFemale(sex)) {
                statePopulation.setWomen(amount);
            }
        }
    }

    private boolean isFemale(String sex) {
        return "C11-2".equals(sex);
    }

    private boolean isMale(String sex) {
        return "C11-1".equals(sex);
    }

    private StatePopulation getOrCreateStatePopulation(Population population, State state) {
        Optional<StatePopulation> optionalStatePopulation = population.getPopulation().stream().filter(sp -> sp.getState().getCode().equals(state.getCode())).findFirst();

        if(optionalStatePopulation.isPresent()) {
            return optionalStatePopulation.get();
        } else {
            StatePopulation statePopulation = new StatePopulation(state);
            population.getPopulation().add(statePopulation);

            return statePopulation;
        }
    }

    private Population getOrCreatePopulation(Map<Integer, Population> map, int year) {
        Population population = map.get(year);

        if (population == null) {
            population = new Population(year, new ArrayList<>());
            map.put(year, population);
        }

        return population;
    }
}
