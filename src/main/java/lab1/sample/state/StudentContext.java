package lab1.sample.state;

import javafx.scene.layout.Pane;

public class StudentContext implements State {

    private State state;

    public State getMyState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void doAction(Pane paneWay) {
        state.doAction(paneWay);
    }
}
