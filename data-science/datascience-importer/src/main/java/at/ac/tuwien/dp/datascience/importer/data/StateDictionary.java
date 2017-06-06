package at.ac.tuwien.dp.datascience.importer.data;

import at.ac.tuwien.dp.datascience.domain.entity.State;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by christoph on 16.05.17.
 */
public class StateDictionary {
    private final Map<String, State> dictionary;

    private StateDictionary(Map<String, State> dictionary) {
        this.dictionary = dictionary;
    }

    public static StateDictionary of(List<State> states) {
        Map<String, State> dictionary = new HashMap<>(states.size());
        for(State state : states) {
            dictionary.put(state.getCode(), state);
        }

        return new StateDictionary(dictionary);
    }

    public State get(String code) {
        return dictionary.get(code);
    }
}
