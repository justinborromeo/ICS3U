/*
 * Using the scanner to read input from the user/keyboard
 * 
 * Prompt the user for 3 digit integer
 * 
 * Display the sum of the three digits to the console
 */

package com.bayviewglen.dayfive;

import java.util.Scanner;

public class DayFiveClassworkThree {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		System.out.print("Please enter a three digit number:  ");
		int number=keyboard.nextInt();
		
		int digit1 = number%10;
		int digit3 = number/100;
		int digit2 = number%100/10;
		
		int sum = digit1 + digit3 + digit2;
		
		System.out.println("The sum of the numbers " + digit3 + ", " + digit2 + ", " + digit3 + " is " + sum);
		
		keyboard.close();

	}

}
