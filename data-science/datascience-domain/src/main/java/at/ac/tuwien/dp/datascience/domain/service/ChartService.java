package at.ac.tuwien.dp.datascience.domain.service;

import at.ac.tuwien.dp.datascience.domain.entity.ChartData;
import at.ac.tuwien.dp.datascience.domain.entity.Population;
import at.ac.tuwien.dp.datascience.domain.entity.Serie;
import at.ac.tuwien.dp.datascience.domain.entity.StatePopulation;
import at.ac.tuwien.dp.datascience.domain.repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by christoph on 17.05.17.
 */
@Component
public class ChartService {
    @Autowired
    private PopulationRepository populationRepository;

    public ChartData getChartData() {
        List<Population> populations = getSortedPopulations();
        return new ChartData(getCategories(populations), getSeries(populations));
    }

    private List<String> getCategories(List<Population> populations) {
        return populations.stream().map(p -> p.getYear()).map(String::valueOf).collect(Collectors.toList());
    }

    private List<Serie> getSeries(List<Population> populations) {
        Map<String, List<Integer>> data = new LinkedHashMap<>();
        for(Population population : populations) {
            collect(data, population);
        }

        List<Serie> series = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> entry : data.entrySet()) {
            series.add(new Serie(entry.getKey(), entry.getValue()));
        }

        return series;
    }

    private void collect(Map<String, List<Integer>> data, Population population) {
        for(StatePopulation statePopulation : population.getPopulation()) {
            List<Integer> values = getOrCreateEntry(data, statePopulation);
            values.add(statePopulation.getMen() + statePopulation.getWomen());
        }
    }

    private List<Integer> getOrCreateEntry(Map<String, List<Integer>> data, StatePopulation statePopulation) {
        String stateName = statePopulation.getState().getState();
        List<Integer> values = data.get(stateName);

        if(values == null) {
            values = new LinkedList<>();
            data.put(stateName, values);
        }

        return values;
    }

    private List<Population> getSortedPopulations() {
        return populationRepository.findAll(new Sort("year"));
    }
}
