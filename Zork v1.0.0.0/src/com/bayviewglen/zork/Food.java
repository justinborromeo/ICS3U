package com.bayviewglen.zork;
/*
 * This is an object class for any item that can be eaten (food).  The class extends the Item class.
 * The heal variable indicates the size of the food item's Health Point (HP) boost.
 */
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