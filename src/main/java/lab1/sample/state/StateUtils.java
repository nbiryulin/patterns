package lab1.sample.state;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class StateUtils {

    public static Group doAction(Image image){
        Rectangle state = new Rectangle(500, 300);
        state.setFill(new ImagePattern(image));
        state.setTranslateY(200);
        state.setTranslateX(100);

        Group group = new Group();
        group.getChildren().add(state);
        return group;
    }
}
