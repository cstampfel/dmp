package at.ac.tuwien.dp.datascience.domain.entity;

import java.util.List;

/**
 * Created by christoph on 17.05.17.
 */
public class ChartData {
    private List<String> categories;
    private List<Serie> series;

    public ChartData(List<String> categories, List<Serie> series) {
        this.categories = categories;
        this.series = series;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<Serie> getSeries() {
        return series;
    }
}
