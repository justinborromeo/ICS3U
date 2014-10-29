/*
 * Compute and print the number of minutes in a year
 */

package com.bayviewglen.daysix;

public class DaySixClassworkThree {

	static final int DAYS_IN_YEAR = 365;
	static final  int HOURS_IN_DAY = 24;
	static final int MINUTES_IN_HOUR = 60;

	public static void main(String[] args) {

		// Final int makes the integer into a constant
		// Final double makes the double into a a constant
		// Naming convention for constants is all uppercase with underscores to separate words
		// Constants are usually declared outside of the main so that other things can use the constants
			
		// Will lose marks on assignments for using magic numbers (numbers that are not defined 
		// as ints or doubles) because it makes the code non-user friendly

		int minutesinyear;

		minutesinyear = (DAYS_IN_YEAR * HOURS_IN_DAY * MINUTES_IN_HOUR);

		System.out.println("The number of minutes in a year is "+ minutesinyear + ".");

	}

}
