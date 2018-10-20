package BasicExample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FXExample {
}


class HelloWorld extends Application {

    //inner class for button event-handler
    private class ButtonHandler implements EventHandler <ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Hello World!");
        }
    }

    @Override
    public void start(Stage primaryStage) {

        //set the button
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new ButtonHandler());

        //set the root container
        StackPane root = new StackPane();
        //add button to root
        root.getChildren().add(btn);

        //create scene with the root
        Scene scene = new Scene(root, 300, 250);

        //set the stage and add the scene
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args); //launch the application
    }

}



