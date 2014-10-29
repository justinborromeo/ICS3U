/*
 * We are declaring a scanner to read input from the keyboard
 * 
 * Reading integer data
 * 
 * Prompt the user for three different integers and display the average of the three numbers
 */

package com.bayviewglen.dayfive;

import java.util.Scanner;

public class DayFiveClassworkOne {

	public static void main(String[] args) {
		// The Scanner is what we're going to use to get information from the
		// keyboard
		// At first, it will show an error. To remove the error, import the
		// scanner from java.util
		// in stands for input (keyboard)

		Scanner SampleScanner = new Scanner(System.in);

		int x, y, z;

		// If we use println, the user will input below the line of text that
		// the system prints

		System.out.print("Please enter three integers:  ");
		x = SampleScanner.nextInt();
		y = SampleScanner.nextInt();
		z = SampleScanner.nextInt();
	
		/* 
		 * nextInt grabs the next integer (the integers that are typed in are stored in the buffer until called upon)
		 */
		
		double average= ((x+y+z)/3.0);
		
		System.out.println("The average of the numbers: " + x + " , " + y + " , " + z + " is " +average);
		
		//If a string is entered as an integer, you get a runtime error
		
		SampleScanner.close();
		
		
		// All functions have round brackets because some need information
		
		//Close the scanner because it is a resource
		
	}

}
