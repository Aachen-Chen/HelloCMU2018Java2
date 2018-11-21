package BasicExample.FXExamples;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class A_MyApp extends Application {
    public void start(Stage stage) {
        //add scene to the stage
        stage.setScene(
            //create scene with root and size 250 x 100
            new Scene(
                //add circle to a new Group named root
                new Group(
                    //create circle of radius = 30 at x=40, y=40
                    new Circle(40, 40, 30)
                ), 250, 100)
        );
        stage.setTitle("My JavaFX Application"); //set the stage
        stage.show();								 //made stage visible
    }
    public static void main(String[] args) {
        //launch the application
        launch(args);
    }
}
