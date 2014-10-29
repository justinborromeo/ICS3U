/*
 * Given a positive number, print its square and its square root
 */

package com.bayviewglen.daysix;

import java.util.Scanner;

public class DaySixClassworkEight {

	public static void main(String[] args) {
		
		Scanner SampleScanner = new Scanner(System.in);
	
		System.out.print("Please enter a positive integer to find the square and the square root:  ");
		
		double number = SampleScanner.nextDouble();
		double square, root;
		
		
		square=Math.pow(number, 2);
		root=Math.sqrt(number);
		
		System.out.println("The square of " + number + " is " + square);
		System.out.println("The square root of " + number + " is " + root);
		
		SampleScanner.close();
		
	}

}
