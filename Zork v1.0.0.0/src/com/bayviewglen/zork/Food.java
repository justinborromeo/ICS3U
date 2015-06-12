package com.bayviewglen.zork;

public class Food extends Item{
	private int heal;
	
	public Food(String name, int heal) {
		super(name);
		this.setHeal(heal);
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

}
