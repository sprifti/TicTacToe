package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Entity.player2Table;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {

	private static Stage stage;
	private static Parent page;


	@Override
	public void start(Stage primaryStage) {
		try {


			stage=primaryStage;
			primaryStage.setTitle("Tic Tac Toe");
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,450,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			ShowMessage.display("Message!!","Click on the 'Who is playing?' button\n to enter the names of the players\n",true);
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}



	public static void replaceSceneContent(String fxml, String title) throws Exception    {


        page = (Parent) FXMLLoader.load(Main.class.getResource(fxml));

        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.setTitle(title == null ? "" : title);
        stage.resizableProperty().setValue(true);
        stage.show();
    }


}

