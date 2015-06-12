package com.bayviewglen.zork;

import java.io.Serializable;

public class Troll implements Serializable{
private int trollhealth;
private int trollaccuracy;
	
public Troll(int health, int accuracy) {
		trollhealth=health;
		trollaccuracy=accuracy;
		
}

public int getTrollhealth() {
	return trollhealth;
}

public void setTrollhealth(int trollhealth) {
	this.trollhealth = trollhealth;
}

public int getTrollaccuracy() {
	return trollaccuracy;
}

public void setTrollaccuracy(int trollaccuracy) {
	this.trollaccuracy = trollaccuracy;
}
}
