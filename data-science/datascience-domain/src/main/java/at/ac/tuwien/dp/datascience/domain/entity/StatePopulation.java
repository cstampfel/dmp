package at.ac.tuwien.dp.datascience.domain.entity;

/**
 * Created by christoph on 16.05.17.
 */
public class StatePopulation {
    private State state;
    private int men;
    private int women;

    public StatePopulation() {
    }

    public StatePopulation(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getMen() {
        return men;
    }

    public void setMen(int men) {
        this.men = men;
    }

    public int getWomen() {
        return women;
    }

    public void setWomen(int women) {
        this.women = women;
    }
}
