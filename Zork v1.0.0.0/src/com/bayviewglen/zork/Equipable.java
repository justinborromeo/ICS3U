package com.bayviewglen.zork;

/*
 * This is an object class for any item that can be equipped (any weapon).  The class extends the Item class.
 * The multipliers indicate the statistic boost given by the Equipable item.
 */

public class Equipable extends Item{
	private double playerhealthmultiplier;
	private double PLAYER_SPEEDmultiplier;
	private double ACCURACYmultiplier;
	private double ATTACKmultiplier;
	private int weight;
	
	public Equipable(String name, double d, double e, double f, double g, int k) {
		super(name);
		
		playerhealthmultiplier = d;
		PLAYER_SPEEDmultiplier = e;
		ACCURACYmultiplier = f;
		ATTACKmultiplier = g;
		setWeight(k);
		
	}
	
	public Equipable(String name) {
		super(name);
	}


	public double getPlayerhealthmultiplier() {
		return playerhealthmultiplier;
	}


	public void setPlayerhealthmultiplier(int playerhealthmultiplier) {
		this.playerhealthmultiplier = playerhealthmultiplier;
	}


	public double getPLAYER_SPEEDmultiplier() {
		return PLAYER_SPEEDmultiplier;
	}


	public void setPLAYER_SPEEDmultiplier(int pLAYER_SPEEDmultiplier) {
		PLAYER_SPEEDmultiplier = pLAYER_SPEEDmultiplier;
	}


	public double getACCURACYmultiplier() {
		return ACCURACYmultiplier;
	}


	public void setACCURACYmultiplier(int aCCURACYmultiplier) {
		ACCURACYmultiplier = aCCURACYmultiplier;
	}


	public double getATTACKmultiplier() {
		return ATTACKmultiplier;
	}


	public void setATTACKmultiplier(int aTTACKmultiplier) {
		ATTACKmultiplier = aTTACKmultiplier;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}