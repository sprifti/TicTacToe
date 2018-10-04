package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player2Table")
public class player2Table {

	@Id
	@Column(name="name2")
	private String player2;
	@Column(name="score2")
	private int playerTwo;

	public player2Table(){}

	public player2Table(String player2, int playerTwo) {
		this.player2 = player2;
		this.playerTwo = playerTwo;
	}

	public String getPlayer2() {
		return player2;
	}
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	public int getPlayerTwo() {
		return playerTwo;
	}
	public void setPlayerTwo(int playerTwo) {
		this.playerTwo = playerTwo;
	}

	@Override
	public String toString() {
		return "player2Table [player2=" + player2 + ", playerTwo=" + playerTwo + "]";
	}




}
