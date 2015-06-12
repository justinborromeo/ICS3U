package com.bayviewglen.zork;

import java.io.Serializable;

public class BarbarianKing implements Serializable{
	private int kinghealth;
	private int kingaccuracy;
		
	public BarbarianKing(int health, int accuracy) {
			kinghealth=health;
			kingaccuracy=accuracy;
	}

	public int getKinghealth() {
		return kinghealth;
	}

	public void setKinghealth(int kinghealth) {
		this.kinghealth = kinghealth;
	}

	public int getKingaccuracy() {
		return kingaccuracy;
	}

	public void setKingaccuracy(int kingaccuracy) {
		this.kingaccuracy = kingaccuracy;
	}
}
