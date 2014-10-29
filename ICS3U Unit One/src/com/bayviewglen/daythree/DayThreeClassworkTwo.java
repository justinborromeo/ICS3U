/*
 * Used variables, assignment operator, string concatenation, primitive datatypes (int and double) but our example used
 * only int
 */

package com.bayviewglen.daythree;

public class DayThreeClassworkTwo {

	public static void main(String[] args) {
		/*
		 * Variables store information and values
		 * Variables have a type and names
		 * If variable x is a whole number, it is an integer
		 * If variable x is a decimal, it is a double
		 * When declaring a variable, the name of the variable must not start with an uppercase letter but the second word can
		 * The program gives a warning if a variable is not used
		 * Integer: int
		 */
		
		// Declare three integers
		int numberOne; // notice the naming convention of the variable(camelCase)
		int numberTwo;
		int sum;

		// The equals sign is the assignment operator
		// The left-hand side of an assignment must be a variable

		numberOne = 8;
		// numberOne is assigned 7
		numberTwo = 5;

		sum = numberOne + numberTwo;

		System.out.println(sum);
		
		//concatenation is the ability to join strings together to create a new string
		//we concatenate strings with a plus sign
		
		System.out.println(numberOne+ " + " + numberTwo + " = " +sum);

	}

}
