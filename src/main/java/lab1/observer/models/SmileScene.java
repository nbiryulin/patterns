package lab1.observer.models;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lab1.observer.DrawUtils;
import lab1.observer.FigureEnum;

public class SmileScene {
    private final Group defaultGroup;
    private Publisher publisher = new Publisher();

    public SmileScene(Stage primaryStage) {
        defaultGroup = new Group();
        primaryStage.setScene(new Scene(defaultGroup, 300, 300));

        drawEyesAndFace();
        drawNose();
        drawMonth();

        defaultGroup.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getTarget() instanceof Node) {
                Node circle = (Node) mouseEvent.getTarget();
                try {
                    Parent parent = circle.getParent();
                    if (parent == null) {
                        return;
                    }

                    String id = parent.getId();
                    if (id == null) {
                        return;
                    }

                    publisher.notify(FigureEnum.fromString(id));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return;
            }

        });

        primaryStage.show();
    }

    private void drawMonth() {
        Mouth mouth = new Mouth(100, 200, 200, FigureEnum.MOUTH.getNameFigure());
        defaultGroup.getChildren().add(mouth.getMouthGroup());

        publisher.subscribe(FigureEnum.MOUTH, mouth);
    }

    private void drawNose() {
        Nose nose = new Nose(150, 150, 25, FigureEnum.NOSE.getNameFigure());
        defaultGroup.getChildren()
                .add(nose.getNoseGroup());

        publisher.subscribe(FigureEnum.NOSE, nose);
    }

    private void drawEyesAndFace() {
        defaultGroup.getChildren().add(DrawUtils.drawCircle(150, 150, 145));

        Eye leftEye = new Eye(90, 100, 50, FigureEnum.LEFT_EYE.getNameFigure());
        Eye rightEye = new Eye(210, 100, 50, FigureEnum.RIGHT_EYE.getNameFigure());

        publisher.subscribe(FigureEnum.LEFT_EYE, leftEye);
        publisher.subscribe(FigureEnum.RIGHT_EYE, rightEye);

        defaultGroup.getChildren().addAll(new Group[]{
                leftEye.getEyeGroup(),
                rightEye.getEyeGroup()
        });
    }

}
