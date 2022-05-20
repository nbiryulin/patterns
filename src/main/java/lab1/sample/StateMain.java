package lab1.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StateMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(new URL("file:/Users/nbiryulin/Desktop/patterns/src/main/java/lab1/sample/sample.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root, 900, 700);
            Stage stage = new Stage();
            stage.setTitle("Student states");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
