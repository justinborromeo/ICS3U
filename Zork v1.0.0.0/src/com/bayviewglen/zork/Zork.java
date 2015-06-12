package com.bayviewglen.zork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Zork {

	public static void main(String[] args) throws InterruptedException {
		Game game;
		
		
		game = new Game();
    	game.play();
    	
	
	}

}