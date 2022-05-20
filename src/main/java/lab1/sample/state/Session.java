package lab1.sample.state;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Session implements State {

    Image img = new Image("file:/Users/nbiryulin/Desktop/patterns/src/main/java/lab1/sample/session.jpg");

    @Override
    public void doAction(Pane paneWay) {
        Group group = StateUtils.doAction(img);
        paneWay.getChildren().add(group);
    }
}
