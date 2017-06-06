package at.ac.tuwien.dp.datascience.domain.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christoph on 16.05.17.
 */
public class Population {
    @Id
    private int id;

    private int year;
    private List<StatePopulation> population = new ArrayList<>();

    public Population() {
    }

    public Population(int year, List<StatePopulation> population) {
        this.year = year;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<StatePopulation> getPopulation() {
        return population;
    }

    public void setPopulation(List<StatePopulation> population) {
        this.population = population;
    }
}
