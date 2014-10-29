/*
 * Find and print the area and perimeter of a rectangle that is 4.5 feet long and 2.3 feet wide.  
 * Print both rounded to the nearest tenth of a foot.
 */

package com.bayviewglen.daysix;

public class DaySixClassworkTwo {

	public static void main(String[] args) {
	
		double length=4.5;
		double width=2.3;
		double area, perimeter;
		
		//truncated but not rounded
		
		area = (int)(length * width * 10) / 10.0;
		perimeter=(int)(2*length)+(2*width);
		
	
	
		
		
		System.out.println("The area of a rectangle with length " + length + " and width " + width + " is " + area);
		
		System.out.println("The perimeter of a rectangle with length " + length + " and width " + width + " is " + perimeter);
		
		

	}
}
