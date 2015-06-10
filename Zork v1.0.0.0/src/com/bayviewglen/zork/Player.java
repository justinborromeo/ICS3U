package com.bayviewglen.zork;



public class Player {

	private String name;
	private  Inventory playerinv;
	private int playerhealth;
	private int PLAYER_SPEED;
	private int ACCURACY;
	private int ATTACK;
	
	public Player(String name){
		this.name = name;
		this.playerinv=new Inventory();
		playerhealth=50;
		PLAYER_SPEED=50;
		ACCURACY=50;
		ATTACK=10;
	}
	
	public int getPlayerSpeed() {
		return PLAYER_SPEED;
	}

	
	
	public Inventory getPlayerInv() {
		return playerinv;
	}
	public void setPlayerInv(Inventory playerinv) {
      this.playerinv = playerinv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerhealth() {
		return playerhealth;
	}

	public void setPlayerhealth(int playerhealth) {
		this.playerhealth = playerhealth;
	}

	public int getACCURACY() {
		return ACCURACY;
	}

	public void setACCURACY(int aCCURACY) {
		ACCURACY = aCCURACY;
	}

	public int getATTACK() {
		return ATTACK;
	}

	public void setATTACK(int aTTACK) {
		ATTACK = aTTACK;
	}


	
	

}
