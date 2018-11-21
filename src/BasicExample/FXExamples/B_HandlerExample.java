package BasicExample.FXExamples;

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

public class B_HandlerExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        // 1. Define GUI component.
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        //  Interative: .setOnAction(EventHandler)
        btn.setOnAction(new ButtonHandler());
        btn.setOnAction((e)-> System.out.println("Hello World!"));

        // 2. Define root container and add component
        // Set the root container, add button to root
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // 3. Initiate the program
        // Create scene with the root, set the stage and add the scene
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //inner class for button event-handler
    private class ButtonHandler implements EventHandler <ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Hello World!");
        }
    }

    public static void main(String[] args) {
        launch(args); //launch the application
    }

}



