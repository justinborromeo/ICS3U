package com.bayviewglen.daythree;

public class DayThreeMoney {

	public static void main(String[] args) {
		// Should have $3.41

		int pennies = 1;
		int nickels = 1;
		int dimes = 1;
		int quarters = 1;
		int loonies = 1;
		int toonies = 1;
		int totalmoney;

		totalmoney = ((pennies * 1) + (nickels * 5) + (dimes * 10)
				+ (quarters * 25) + (loonies * 100) + (toonies * 200));

		System.out.println(totalmoney);

	}

}
