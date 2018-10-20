package BasicExample.FXExamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MultiStage extends Application {

    private Stage byeStage = new Stage();
    private Scene byeScene;
    private BorderPane helloRoot = new BorderPane();
    private BorderPane byeRoot = new BorderPane();

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage helloStage) throws Exception {
        // wucao niubi!!
        Button helloButton = new Button("Hello!");
        helloButton.setOnAction(new HelloButtonHandler());

        Button byeButton = new Button("Bye!");
        // Lambda call!
//        byeButton.setOnAction(new ByeButtonHandler());
        byeButton.setOnAction(
                (x) -> byeStage.close()
        );
        // this "x" is a parameter passed to EventHandler<ActionEvent>.handle()

        helloRoot.setCenter(helloButton);
        byeRoot.setCenter(byeButton);

        Scene helloScene = new Scene(helloRoot, 200, 100);
        byeScene = new Scene(byeRoot, 200, 100);

        helloStage.setTitle("Hello Stage");
        helloStage.setScene(helloScene);
        helloStage.show();
    }

    private class HelloButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            byeStage.setTitle("Hello Stage");
            byeStage.setX(500);
            byeStage.setY(300);
            byeStage.setScene(byeScene);
            byeStage.show();
        }
    }
    private class ByeButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            byeStage.close();}
    }
}
