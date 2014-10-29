package com.bayviewglen.dayfive;

import java.util.Scanner;

public class DayFiveHomeworkTestScore {

	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the highest possible test score:  ");
		
		double maxtestscore = keyboard.nextDouble();
		
		System.out.print("Please enter the student's test score:  ");
		
		double testscore = keyboard.nextDouble();
		
		double percentage = ((testscore/maxtestscore)*100);
		
		System.out.println(percentage + "%");
		
		keyboard.close();
		
		
		
		
		
		
		keyboard.close();

	}

}
