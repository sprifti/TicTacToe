package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SampleController {
	private String turn="X";
	private static final String EMPTY_STRING="";
	public  static String player1=EMPTY_STRING;
	public static String player2=EMPTY_STRING;



	private static int playerOne=0;
	private static int playerTwo=0;

	private void nextTurn(){
		if(turn.equals("X")){

			turn="0";
		}
		else {
			turn="X";
		}
	}




	private void Xwin(){
		playerOne++;
		ShowMessage.Information("Information", player1 + " won!\n" , player2 + " starts the next game!" );
		reset();

	}

	private void Owin(){
	    playerTwo++;
	    ShowMessage.Information("Information", player2 + " won!\n" , player1 + " starts the next game!" );
		reset();
	}

	public static void showScores(){
		ShowMessage.display("Scores", "Scores of "+ player1 +" : "+ playerOne + "\n" + "Scores of " + player2 +  " : "+playerTwo,false);
	}

	public static void setPlayer1(String s){
		player1=s;
	}

	public String getPlayer1(){
		return player1;
	}

	public static void setPlayer2(String s){
		player2=s;
	}

	private void reset(){
		button1.setText(EMPTY_STRING);
		button2.setText(EMPTY_STRING);
		button3.setText(EMPTY_STRING);
		button4.setText(EMPTY_STRING);
		button5.setText(EMPTY_STRING);
		button6.setText(EMPTY_STRING);
		button7.setText(EMPTY_STRING);
		button8.setText(EMPTY_STRING);
		button9.setText(EMPTY_STRING);


	}

	//per cdo button krijojme nje string qe do te na sherbeje per te shqyrtuar rastet kur do fitoj "X" dhe kur do fitoj "O"//

	private void whoWon(){
		String one = button1.getText();
		String two = button2.getText();
		String three = button3.getText();
		String four = button4.getText();
		String five = button5.getText();
		String six = button6.getText();
		String seven = button7.getText();
		String eight = button8.getText();
		String nine = button9.getText();




		if(one.equals(two) && two.equals(three) && !one.equals(EMPTY_STRING)){
			if(one.equals("X")){
			Xwin();} else {Owin();}
		}
		if(four.equals(five) && five.equals(six) && !four.equals("") ){
			if(four.equals("X")){
				Xwin();} else {Owin();}
		}
		if(seven.equals(eight) && eight.equals(nine) && !seven.equals("") ){
			if(seven.equals("X")){
				Xwin();} else {Owin();}
		}

		if(one.equals(four) && four.equals(seven) && !one.equals("")){
			if(four.equals("X")){
				Xwin();} else {Owin();}
		}

		if(two.equals(five) && five.equals(eight) && !two.equals("")){
			if(two.equals("X")){
				Xwin();} else {Owin();}
		}

		if(three.equals(six) && six.equals(nine) && !three.equals("") ){
			if(three.equals("X")){
				Xwin();} else {Owin();}
		}

		if(one.equals(five) && five.equals(nine) && !one.equals("")){
			if(one.equals("X")){
				Xwin();} else {Owin();}
		}

		if(three.equals(five) && five.equals(seven) && !three.equals("")){
			if(five.equals("X")){
				Xwin();} else {Owin();}
		}


	}



	//cdo button i krijohet  nje method to handle the action dhe ne Scene builder lidhet me kete method //
	//cdo button i vendoset si tekt karakteri turn dhe therritet methd nextTurn() qe button pasardhes te kete character tjeter//



	@FXML
	Button button1;
    @FXML
   private void handleButton1Action(ActionEvent event){
    	handleButton(button1);

	}

    @FXML
	Button button2;
    @FXML
   private void handleButton2Action(ActionEvent event){
    	handleButton(button2);
	}

    @FXML
	Button button3;
    @FXML
   private void handleButton3Action(ActionEvent event){
    	handleButton(button3);
	}

    @FXML
	Button button4;
    @FXML
   private void handleButton4Action(ActionEvent event){
    	handleButton(button4);
	}

    @FXML
	Button button5;
    @FXML
   private void handleButton5Action(ActionEvent event){
    	handleButton(button5);
    	}

    @FXML
	Button button6;
    @FXML
   private void handleButton6Action(ActionEvent event){
    	handleButton(button6);
	}

    @FXML
	Button button7;
    @FXML
   private void handleButton7Action(ActionEvent event){
    handleButton(button7);	}

    @FXML
	Button button8;
    @FXML
   private void handleButton8Action(ActionEvent event){
    	handleButton(button8);
   }

    @FXML
	Button button9;
    @FXML
   private void handleButton9Action(ActionEvent event){
    	handleButton(button9);
	}

    private void handleButton(Button button){
    	if(button.getText().equals(EMPTY_STRING) && !player1.equals("") && !player2.equals("")){
    		button.setText(turn);
    		nextTurn();
    		whoWon();
    		}

    }

    @FXML
    Button resetButton;
    @FXML
    private void handleResetButtonAction(ActionEvent event){
    	reset();
    }


    @FXML
    Button playersName;
    @FXML
    private void handleButtonPlayersName(ActionEvent event) throws Exception{
    	if(player1.equals(EMPTY_STRING) && player2.equals(EMPTY_STRING)){
    	Main.replaceSceneContent("NamePlayer.fxml", "Player 1");}
    	}

    @FXML
    Button close;
    @FXML
    private void handleButtonClose(ActionEvent event){
    	if(player1.equals(EMPTY_STRING)){Platform.exit();}
    	else
    	{	try{ boolean found1=false; boolean found2=false;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://Desktop-S985:1433;databaseName=TicTacToe;integratedSecurity=true;";
            Connection con = DriverManager.getConnection(url);
            PreparedStatement prep=null;
            int score;
            Statement stm=con.createStatement();
            ResultSet s1=stm.executeQuery("Select * from player1Table");

            while(s1.next()){
            	if(player1.equalsIgnoreCase(s1.getString("name1"))){ found1=true;
            		score=s1.getInt("score1"); score=playerOne+score;
            		prep=con.prepareStatement("Update player1Table Set score1=? where name1=?");
            		prep.setInt(1,score);
            		prep.setString(2, player1);
            		prep.executeUpdate();
            		}
            	}

            if(found1==false) {
            	PreparedStatement prep2=con.prepareStatement("Insert into player1Table(name1,score1) Values(?,?)");
                prep2.setString(1, player1);
                prep2.setInt(2, playerOne);
                prep2.executeUpdate();
}
                  ResultSet s2=stm.executeQuery("Select * from player2Table");
            while(s2.next()){
            	if(player2.equalsIgnoreCase(s2.getString("name2"))){ found2=true;
            		score=s2.getInt("score2"); score=playerTwo+score;
            		prep=con.prepareStatement("Update player2Table Set score2=? where name2=?");
            		prep.setInt(1,score);
            		prep.setString(2, player2);
            		prep.executeUpdate();
            		}
            	}


            	if(found2==false) {
                	PreparedStatement prep2=con.prepareStatement("Insert into player2Table(name2,score2) Values(?,?)");
                    prep2.setString(1, player2);
                    prep2.setInt(2, playerTwo);
                    prep2.executeUpdate();
                }

            Platform.exit();
           }


		catch(Exception e){}}
    }

    public void gameRank(){
    	try{ boolean found1=false; boolean found2=false;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://Desktop-S985:1433;databaseName=TicTacToe;integratedSecurity=true;";
        Connection con = DriverManager.getConnection(url);



    	}
    	catch(Exception e){}

    }





}

