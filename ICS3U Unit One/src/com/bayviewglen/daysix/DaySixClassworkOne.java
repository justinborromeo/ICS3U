/*
 *Susan purchases a computer for $985.  The sales tax on the purchase is 5.5 percent.  Compute and print the
 *total purchase price 
 */

package com.bayviewglen.daysix;

public class DaySixClassworkOne {

	public static void main(String[] args) {
		
	double basecomputerprice=985;
	double salestax=0.055;
	double totalpurchaseprice;
	
	totalpurchaseprice=basecomputerprice*(1+salestax);
	
	System.out.println(totalpurchaseprice);
	
	

	}

}
