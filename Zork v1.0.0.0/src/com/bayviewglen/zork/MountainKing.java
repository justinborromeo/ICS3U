package com.bayviewglen.zork;

public class MountainKing {
	private int kinghealth;
	private int kingspeed;
	private int kingaccuracy;
		
	public MountainKing(int health, int speed, int accuracy) {
			setKinghealth(health);
			setKingspeed(speed);
			setKingaccuracy(accuracy);
	}

	public int getKinghealth() {
		return kinghealth;
	}

	public void setKinghealth(int kinghealth) {
		this.kinghealth = kinghealth;
	}

	public int getKingspeed() {
		return kingspeed;
	}

	public void setKingspeed(int kingspeed) {
		this.kingspeed = kingspeed;
	}

	public int getKingaccuracy() {
		return kingaccuracy;
	}

	public void setKingaccuracy(int kingaccuracy) {
		this.kingaccuracy = kingaccuracy;
	}
}
