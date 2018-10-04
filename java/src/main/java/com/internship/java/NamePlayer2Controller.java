package com.internship.java;

import com.internship.java.App;
import com.internship.java.SampleController;
import com.internship.java.ShowMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class NamePlayer2Controller {
	@FXML
	Button buttonSubmit;
	@FXML
	TextField textField;
	@FXML
	BorderPane borderPane;
	@FXML
	Label label;

	@FXML
	private void handleButtonSubmit(ActionEvent event) throws Exception{
		App.replaceSceneContent("Sample.fxml", "Tic Tac Toe");
		ShowMessage.display("Let's start the game", SampleController.player1 + " starts the game",false);
		SampleController.setPlayer2(textField.getText());
	}
}
