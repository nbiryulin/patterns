package lab1.template;

import javafx.application.Application;
import javafx.stage.Stage;
import lab1.template.Templ.AnimationField;

public class TemplateMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        AnimationField field = new AnimationField();
        field.showAndStart();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
