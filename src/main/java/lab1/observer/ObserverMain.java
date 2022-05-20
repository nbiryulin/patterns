package lab1.observer;

import javafx.application.Application;
import javafx.stage.Stage;
import lab1.observer.models.SmileScene;


public class ObserverMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        new SmileScene(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
