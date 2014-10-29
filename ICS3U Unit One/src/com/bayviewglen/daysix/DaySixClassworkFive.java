/*
 * The 1927 New York Yankees won 110 games and lost 44.  Compute their winning percentage and print it rounded to three
 * decimal places.
 */


package com.bayviewglen.daysix;

public class DaySixClassworkFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double gameswon=110;
		double gameslost=44;
		double  winpercentage;
		
		winpercentage=(int)(gameswon/(gameswon+gameslost) * 1000) / (double) 1000;
		
		System.out.println("The Yankees' win percentage in the 1927 season was: " + winpercentage);
		
	}

}
