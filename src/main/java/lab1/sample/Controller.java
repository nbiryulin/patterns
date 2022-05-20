package lab1.sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import lab1.sample.state.*;


public class Controller {

    private Rectangle state;


    @FXML
    public Pane paneWay = new Pane();

    public void initialize() {
        Image img = new Image("file:/Users/nbiryulin/Desktop/patterns/src/main/java/lab1/sample/start.jpeg");

        state = new Rectangle(500, 300);
        state.setFill(new ImagePattern(img));
        state.setTranslateY(200);
        state.setTranslateX(100);

        Group group = new Group();

        Button buttonSem = new Button("Семестр");
        buttonSem.setLayoutX(700);
        buttonSem.setLayoutY(250);
        buttonSem.setMinSize(100,20);

        Button buttonHoliday = new Button(" Каникулы");
        buttonHoliday.setLayoutX(700);
        buttonHoliday.setLayoutY(300);
        buttonHoliday.setMinSize(100,20);

        Button buttonSes = new Button("Сессия");
        buttonSes.setLayoutX(700);
        buttonSes.setLayoutY(350);
        buttonSes.setMinSize(100,20);

        group.getChildren().add(state);
        group.getChildren().add(buttonSem);
        group.getChildren().add(buttonSes);
        group.getChildren().add(buttonHoliday);
        paneWay.getChildren().add(group);

        StudentContext studentContext = new StudentContext();
        State myHoliday = new Holiday();
        State mySemestr = new Semestr();
        State mySession = new Session();


        buttonSem.setOnMouseClicked (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                studentContext.setState(mySemestr);
                studentContext.doAction(paneWay);
            }
        });

        buttonHoliday.setOnMouseClicked (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                studentContext.setState(myHoliday);
                studentContext.doAction(paneWay);
            }
        });

        buttonSes.setOnMouseClicked (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                studentContext.setState(mySession);
                studentContext.doAction(paneWay);
            }
        });

    }
}







