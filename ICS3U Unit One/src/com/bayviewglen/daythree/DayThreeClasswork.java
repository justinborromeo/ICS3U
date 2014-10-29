package com.bayviewglen.daythree;

public class DayThreeClasswork {

	public static void main(String[] args) {
		// The following characters could cause an issue \, ", ',
		//So we can escape them using the backslash
		
		System.out.println("This \"is\" important");
		
		//Notice how it displays the quotes
		
		System.out.println("This\nis\nimportant");
		
		// \n causes a new line to be started		
		// \g is in an invalid escape sequence so there will be an error
	}

}
