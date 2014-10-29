/*
 * How to 
 */

package com.bayviewglen.dayfive;

import java.util.Scanner;

public class DayFiveClassworkTwo {

	public static void main(String[] args) {

		Scanner BoxScanner = new Scanner(System.in);

		double length, width, height;
		double surfaceArea;

		System.out.print("Please enter length of box:  ");
		length = BoxScanner.nextInt();

		System.out.print("Please enter width of box:  ");
		width = BoxScanner.nextInt();

		System.out.print("Please enter height of box:  ");
		height = BoxScanner.nextInt();

		surfaceArea = ((2 * length * width) + (2 * width * height) + (2 * height * length));

		System.out.println("The surface area of a box with a width of " + width + " a length of " + length
				+ " and a height of " + height + " = " + surfaceArea);

		BoxScanner.close();

	}

}
