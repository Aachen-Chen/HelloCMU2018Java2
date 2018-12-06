package BasicExample.FXExamples.dynamicCalculatorOriginal;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


@SuppressWarnings("serial")
public class InputOutOfRangeException extends IllegalArgumentException{
	
	InputOutOfRangeException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Invalid Input");
		alert.setContentText("Please enter valid input!");


		alert.showAndWait();
	}
	
	InputOutOfRangeException(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Invalid Input");
		alert.setContentText(message);
		alert.showAndWait();

		Alert alert2 = new Alert(AlertType.ERROR);
		alert2.setTitle("This is the second");
		alert2.setContentText("I show again!");
		alert2.showAndWait();
	}
}
