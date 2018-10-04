package application;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowMessage {
	public static String name1;
	public static String name2;
	public static int score1=0;
	public static int score2=0;
	public static void display(String title, String message,boolean show){
		Stage window= new Stage();
		Scene scene1;

		window.setTitle(title);
		Label label=new Label();
		label.setText(message);
		Button button=new Button();
		button.setText("Continue");
		button.setOnAction(e -> window.close());
		Button button2=new Button();
		VBox layout = new VBox();
		layout.setSpacing(15);
		if(show==true){
		button2.setText("Game Rank");
		button2.setOnAction(e -> afisho());

		layout.getChildren().addAll(label,button,button2);
		}
		else

		layout.getChildren().addAll(label,button);
		layout.setAlignment(Pos.CENTER);
		layout.setPrefSize(100, 100);
		scene1=new Scene(layout,300,200);
		window.setScene(scene1);
		window.show();

}

	public static void Information(String title, String message1, String message2){
		Stage window= new Stage();
		Scene scene1;

		window.setTitle(title);
		Label label=new Label();
		label.setText(message1);
		Label label1=new Label();
		label1.setText(message2);
		Button button=new Button();
		Button button1= new Button();
		button1.setText("Scores");
		button1.setOnAction(e-> SampleController.showScores());
		button.setText("Continue");
		button.setOnAction(e ->window.close() );
		VBox layout = new VBox();
		layout.setSpacing(15);
		layout.getChildren().addAll(label,label1,button,button1);
		layout.setAlignment(Pos.CENTER);
		layout.setPrefSize(200, 200);
		scene1=new Scene(layout,300,150);
		window.setScene(scene1);
		window.show();

}



//radhiten lojtaret e te dy tabelave sipas pikeve ne rendin zbrites//
	public static void afisho(){

		try{
		Stage stage=new Stage();
		stage.setTitle("Game Rank");
		Scene scene1;
		TextArea txt= new TextArea();

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://Desktop-S985:1433;databaseName=TicTacToe;integratedSecurity=true;";
        Connection con = DriverManager.getConnection(url);
        Statement stm=con.createStatement();
        Statement stm2=con.createStatement();
        txt.setEditable(false);

        ResultSet rs=stm.executeQuery("(Select * from player1Table) Union all  (Select * from player2Table ) order by score1 desc");
        int i=0;

        while(rs.next() ){

        	txt.appendText( "\t\t\t" + "Rank: " + ++i +  "	Name:	" + rs.getString("name1") + "\n" + "\t\t\t\t\tScore:	" + rs.getInt("score1") + "\n\n" );

        	}

        StackPane spane=new StackPane();
		spane.getChildren().add(txt);
		scene1=new Scene(spane,400,400);
		stage.setScene(scene1);
		stage.show();

   }
    	catch(Exception e1){}



	}

	public static void main(String[] args) {


	}

}
