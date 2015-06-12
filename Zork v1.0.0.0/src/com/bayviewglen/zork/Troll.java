package com.bayviewglen.zork;

import java.io.Serializable;

public class Troll implements Serializable{
private int trollhealth;
private int trollspeed;
private int trollaccuracy;
private int trollattack;
	
public Troll(int health, int speed, int accuracy, int attack) {
		trollhealth=health;
		trollspeed=speed;
		trollaccuracy=accuracy;
		setTrollattack(attack);
}

public int getTrollhealth() {
	return trollhealth;
}

public void setTrollhealth(int trollhealth) {
	this.trollhealth = trollhealth;
}

public int getTrollspeed() {
	return trollspeed;
}

public void setTrollspeed(int trollspeed) {
	this.trollspeed = trollspeed;
}

public int getTrollaccuracy() {
	return trollaccuracy;
}

public void setTrollaccuracy(int trollaccuracy) {
	this.trollaccuracy = trollaccuracy;
}

public int getTrollattack() {
	return trollattack;
}

public void setTrollattack(int trollattack) {
	this.trollattack = trollattack;
}
	
	
}
