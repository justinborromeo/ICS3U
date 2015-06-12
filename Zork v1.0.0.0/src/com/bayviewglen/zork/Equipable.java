package com.bayviewglen.zork;

public class Equipable extends Item{
	private double playerhealthmultiplier;
	private double PLAYER_SPEEDmultiplier;
	private double ACCURACYmultiplier;
	private double ATTACKmultiplier;
	
	public Equipable(String name, double d, double e, double f, double g) {
		super(name);
		
		playerhealthmultiplier = d;
		PLAYER_SPEEDmultiplier = e;
		ACCURACYmultiplier = f;
		ATTACKmultiplier = g;
		
	}
	
	public Equipable(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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

}
