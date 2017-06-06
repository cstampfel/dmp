package at.ac.tuwien.dp.datascience.domain.entity;

import java.util.List;

/**
 * Created by christoph on 17.05.17.
 */
public class Serie {
    private String name;
    private List<Integer> data;

    public Serie(String name, List<Integer> data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getData() {
        return data;
    }
}
