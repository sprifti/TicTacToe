package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class NamePlayerController {
	
	
	
	
	@FXML
	TextField textField;
	@FXML
	BorderPane borderPane;
	@FXML
	Label label;
	
	@FXML 
	Button buttonPlayer2;
	@FXML
	private void handleButtonPlayer2(ActionEvent event) throws Exception{
		Main.replaceSceneContent("NamePlayer2.fxml", "Player 2");
		SampleController.setPlayer1(textField.getText());
		
       
	}
	
	
	
}
