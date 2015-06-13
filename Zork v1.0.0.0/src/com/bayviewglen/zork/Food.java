package com.bayviewglen.zork;

public class Food extends Item{
	private int heal;
	private int weight;
	
	public Food(String name, int heal, int weight) {
		super(name);
		this.setHeal(heal);
		this.setWeight(weight);
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
