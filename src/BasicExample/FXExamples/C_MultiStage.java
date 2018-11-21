package BasicExample.FXExamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class C_MultiStage extends Application {

    private Stage byeStage = new Stage();
    private Scene byeScene;
    private BorderPane helloRoot = new BorderPane();
    private BorderPane byeRoot = new BorderPane();

    @Override
    public void start(Stage helloStage) throws Exception {
        // wucao niubi!!
        Button helloButton = new Button("Hello!");
        helloButton.setOnAction(new HelloButtonHandler());

        helloRoot.setCenter(helloButton);
        Scene helloScene = new Scene(helloRoot, 200, 100);

        helloStage.setTitle("Hello Stage");
        helloStage.setScene(helloScene);
        helloStage.show();
    }

    private class HelloButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button byeButton = new Button("Bye!");
            // Lambda call!
            byeButton.setOnAction((x) -> byeStage.close());
            // this "x" is a parameter passed to EventHandler<ActionEvent>.handle()

            byeRoot.setCenter(byeButton);
            byeScene = new Scene(byeRoot, 200, 100);

            byeStage.setTitle("Hello Stage");
            byeStage.setX(500);
            byeStage.setY(300);
            byeStage.setScene(byeScene);
            byeStage.show();
        }
    }

    public static void main(String[] args) { launch(args); }
}
