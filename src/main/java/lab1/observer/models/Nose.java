package lab1.observer.models;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lab1.observer.DrawUtils;
import lab1.observer.interfaces.Observer;

public class Nose implements Observer {
    private Group noseGroup;
    private Circle circle;
    private double x;
    private double y;
    private double r;

    public Group getNoseGroup() {
        return noseGroup;
    }

    public Nose(double x, double y, double r, String id) {
        noseGroup = new Group();
        noseGroup.setId(id);
        this.x = x;
        this.y = y;
        this.r = r;

        drawNose();
    }

    private void drawNose() {
        circle = DrawUtils.drawCircle(x, y, r);
        circle.setFill(Color.BLUE);

        noseGroup.getChildren().add(circle);
    }

    @Override
    public void update() {
        circle.setFill(
                circle.getFill() == Color.BLUE
                        ? Color.RED
                        : Color.BLUE
        );
    }

}
