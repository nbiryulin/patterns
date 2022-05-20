package lab1.sample.state;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Semestr implements State {

    Image img = new Image("file:/Users/nbiryulin/Desktop/patterns/src/main/java/lab1/sample/semestr.jpg");

    @Override
    public void doAction(Pane paneWay) {
        Group group = StateUtils.doAction(img);
        paneWay.getChildren().add(group);
    }
}
