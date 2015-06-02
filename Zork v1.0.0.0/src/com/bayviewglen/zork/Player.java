package com.bayviewglen.zork;

import java.util.Collection;

public class Player {

	private static String name;
	private static Inventory playerinv;
	private static int playerhealth;
	static final int PLAYER_SPEED=50;
	static final int ACCURACY=50;
	static final int ATTACK=10;
	
	
	public static int getPlayerSpeed() {
		return PLAYER_SPEED;
	}

	public Player(String name){
		Player.name = name;
		this.playerinv=new Inventory();
		playerhealth=50;
		
	}
	
	public static Inventory getPlayerInv() {
		return playerinv;
	}
	public static void setPlayerInv(Inventory playerinv) {
		Player.playerinv = playerinv;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Player.name = name;
	}

	public int getPlayerhealth() {
		return playerhealth;
	}

	public void setPlayerhealth(int playerhealth) {
		Player.playerhealth = playerhealth;
	}
	
	

}
