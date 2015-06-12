package com.bayviewglen.zork;

import java.io.Serializable;



public class Player implements Serializable{

	private String name;
	private  Inventory playerinv;
	private  Inventory equipped;
	private int playerhealth;
	private int PLAYER_SPEED;
	private int ACCURACY;
	private int ATTACK;
	
	public Player(String name){
		this.name = name;
		playerinv=new Inventory();
		setEquipped(new Inventory());
		playerhealth=50;
		PLAYER_SPEED=50;
		ACCURACY=50;
		ATTACK=10;
	}
	
	public int getPlayerSpeed() {
		return PLAYER_SPEED;
	}

	public void setPlayerSpeed(int n) {
	PLAYER_SPEED=n;
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

	public Inventory getEquipped() {
		return equipped;
	}

	public void setEquipped(Inventory equipped) {
		this.equipped = equipped;
	}


	
	

}
