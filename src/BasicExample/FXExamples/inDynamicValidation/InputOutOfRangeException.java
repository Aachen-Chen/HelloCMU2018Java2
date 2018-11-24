package mortgage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class InputOutOfRangeException extends IllegalArgumentException{
	InputOutOfRangeException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Invalid Input");
		alert.setContentText("Please enter valid input!");
		alert.showAndWait();
	}
}
