package at.ac.tuwien.dp.datascience.domain.entity;

/**
 * Created by christoph on 16.05.17.
 */
public class State {
    private String code;
    private String state;

    public State(String code, String state) {
        this.code = code;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public String getState() {
        return state;
    }
}
