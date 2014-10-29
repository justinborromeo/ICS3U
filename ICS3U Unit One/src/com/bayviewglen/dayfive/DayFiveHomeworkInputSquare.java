package com.bayviewglen.dayfive;

import java.util.Scanner;

public class DayFiveHomeworkInputSquare {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a number:  ");
		
		int number = keyboard.nextInt();
		
		System.out.println(number*number);
		
		keyboard.close();

	}

}
