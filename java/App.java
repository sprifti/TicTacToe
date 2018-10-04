package com.internship.java;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class App extends Application
{
	private static Stage stage;
	private static Parent page;


	@Override
	public void start(Stage primaryStage) {
		try {


			stage=primaryStage;
			primaryStage.setTitle("Tic Tac Toe");
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,450,450);
			scene.getStylesheets().add(getClass().getResource("Sample.fxml").toExternalForm());
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


        page = (Parent) FXMLLoader.load(App.class.getResource(fxml));

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
