package BasicExample.FXExamples.dynamicValidation;

import javafx.application.Application;
import javafx.beans.binding.ObjectBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** MortgageCalculator takes three user inputs - principal, interest, and loan term, and calculates monthly mortgage.
 * It also uses one custom exception InputOutOfRangeException
 * @author ndwivedi
 */

public class MortgageCalculator extends Application{
	GridPane root = new GridPane();
	TextField principalTextField = new TextField();		//takes principal input
	TextField interestTextField = new TextField();		//takes interest rate input
	TextField termTextField = new TextField();		//takes loan term input
	Label mortgageValue = new Label("");				//used to display mortgage result value
	Button calculateButton = new Button ("Calculate");
	Mortgage mortgage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		setupScene();
		Scene scene = new Scene(root, 350, 175);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Dynamic Mortgage");

		// Dynamic calculation
		mortgageBinding.addListener((observable, oldValue, newValue) -> {
			// newValue is the value return by binding's computeValue's return
			if (newValue != null) {
//				mortgage = newValue;
//				if (
//					!(mortgage.principal < 10000 || mortgage.principal  > 1000000) &&
//					!(mortgage.interest < 0 || mortgage.interest > 25) &&
//					!(mortgage.term < 15 || mortgage.term > 30)) {
//					mortgageValue.setText(String.format(
//							"Monthly mortgage is $%,.2f",
//							newValue.calculateMortgage()));
//				} else mortgageValue.setText("");
				mortgageValue.setText(String.format(
						"Monthly mortgage is $%,.2f",
						newValue.calculateMortgage()));
			} else  mortgageValue.setText("");
		});
		primaryStage.show();		
	}

	// Dynamic color
	ObjectBinding<Mortgage> mortgageBinding = new ObjectBinding<>() {
		{
			super.bind(
					principalTextField.textProperty(),
					interestTextField.textProperty(),
					termTextField.textProperty()
			);
		}

		// wrong type show red
		@Override
		protected Mortgage computeValue() {
//			double principal = 0, interest = 0, term = 0;
			TextField textField = principalTextField;
			mortgage = new Mortgage();
			try {
				textField.setStyle("-fx-text-inner-color: black;");
				mortgage.setPrincipal(Double.parseDouble(textField.getText().trim()));

				textField = interestTextField;
				textField.setStyle("-fx-text-inner-color: black;");
				mortgage.setInterest(Double.parseDouble(textField.getText().trim()));

				textField = termTextField;
				textField.setStyle("-fx-text-inner-color: black;");
				mortgage.setTerm(Double.parseDouble(textField.getText().trim()));

				return mortgage;
			} catch (NumberFormatException | InputOutOfRangeException e) {
				textField.setStyle("-fx-text-inner-color: red;");
				return null;
			}
		}

	};

	// report integrity
	private class CalculateHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			try {
				mortgageBinding.get();
//				if (mortgage.principal < 10000 || mortgage.principal  > 1000000)
//					 //when throw, show alert
//					throw new InputOutOfRangeException("Principal out of range. Must be between 10k and 1m");
//				if (mortgage.interest < 0 || mortgage.interest > 25)
//					throw new InputOutOfRangeException("Interest out of range. Must be between 0 and 25");
//				if (mortgage.term < 15 || mortgage.term > 30)
//					throw new InputOutOfRangeException("Term out of range. Must be between 15 and 30");
			} catch (InputOutOfRangeException | NullPointerException e) {
				// after showing alert in throw, catch, and do new action.
				mortgageValue.setText("Please enter valid value");
			}
		}
	}

	private class ClearHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			principalTextField.clear();
			interestTextField.clear();
			termTextField.clear();
			principalTextField.setStyle("-fx-text-inner-color: black;");
			interestTextField.setStyle("-fx-text-inner-color: black;");
			termTextField.setStyle("-fx-text-inner-color: black;");
			mortgageValue.setText("");
		}
	}


	public void setupScene() {
		Label principalLabel = new Label("Principal amount $10k-1m");
		Label interestLabel = new Label("Interest rate 0-25%");
		Label termLabel = new Label("Loan term 15-30 years");


		Button clearButton = new Button("Clear");

		root.add(principalLabel, 0, 0);
		root.add(interestLabel, 0, 1);
		root.add(termLabel, 0, 2);
		root.add(principalTextField, 1, 0);
		root.add(interestTextField, 1, 1);
		root.add(termTextField, 1, 2);

		root.add(mortgageValue, 0, 3, 2, 1);

		root.add(calculateButton, 0, 4);
		calculateButton.setPrefWidth(100);

		root.add(clearButton, 1, 4);
		clearButton.setPrefWidth(100);
		calculateButton.setOnAction(new CalculateHandler());
		clearButton.setOnAction(new ClearHandler());

		root.setHgap(5);
		root.setVgap(5);
		root.setPadding(new Insets(25,25,25,25));
	}

	public static void main(String[] args) {
		launch(args);
	}

}
