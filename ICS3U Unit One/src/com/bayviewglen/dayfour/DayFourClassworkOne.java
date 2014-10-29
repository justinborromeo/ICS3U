package com.bayviewglen.dayfour;

public class DayFourClassworkOne {

	public static void main(String[] args) {
		System.out.println(3*6);   //18
		System.out.println(3+6);   //9
		System.out.println(3/6);   //0 - both operands are integers (truncates)

		
		System.out.println(3.0*6);   //18
		System.out.println(3.0+6);   //9
		System.out.println(3.0/6);   //0 - does not truncate because one operand is a double
		
		System.out.println(3%6);  // Remainder 3
		System.out.println(23%2);  // Remainder 1 - this is how we can find out if it is even or odd
		System.out.println(45685449%10);  //modulo it by 10 to get the last digit
		
	}

}
