package com.bayviewglen.zork;

import java.util.Collection;

public class Player {

	private static String name;
	private static Inventory playerinv;
	
	
	public Player(String name){
		Player.name = name;
		this.playerinv=new Inventory();
		
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
	
	

}
