package com.bayviewglen.zork;

import java.io.Serializable;

public class Item implements Serializable{
//An Item object is anything that can be taken in the game.
	private String name;
	
	public Item(String name){
		this.name = name;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
//k