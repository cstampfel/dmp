package at.ac.tuwien.dp.datascience.importer.csv;

import at.ac.tuwien.dp.datascience.domain.entity.State;
import at.ac.tuwien.dp.datascience.importer.data.StateDictionary;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by christoph on 16.05.17.
 */
@Component
public class StateParser {
    private static final CSVFormat CSV_FORMAT = CSVFormat.EXCEL.withDelimiter(';');

    public StateDictionary parse() throws IOException, URISyntaxException {
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("OGD_f1197_Bev_Jahresdurchschn_1_C-B00-0.csv")) {
            List<String> lines = IOUtils.readLines(input, "UTF-8");
            String content = lines.stream().skip(2).collect(Collectors.joining("\n"));

            List<State> states = new ArrayList<>();

            for (CSVRecord record : CSVParser.parse(content, CSV_FORMAT)) {
                String code = record.get(0);
                String rawState = record.get(1);
                String state = rawState.substring(0, rawState.lastIndexOf(" "));

                states.add(new State(code, state));
            }

            return StateDictionary.of(states);
        }
    }
}
