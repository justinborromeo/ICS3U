/*
 * Name: Justin Borromeo
 * Course: ICS3U-AP
 * Title: Cross-Country Assignment
 * Description: 
 * Due Date: October 31, 2014
 * Teacher: Mr. Deslauriers
 */

package com.bayviewglen.crosscountryassignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {

	static int SECONDS_IN_A_MINUTE = 60;

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		/*RUNNER ONE---RUNNER ONE---RUNNER ONE---RUNNER ONE---RUNNER ONE---RUNNER ONE---RUNNER ONE*/
		
		// Requests all information for the first runner
		// one_ is the prefix for all the first runner's info)

		System.out.println("FIRST RUNNER");

		System.out.print("Please enter your first and last name: ");
		String one_name = keyboard.nextLine();
		
		int one_splitone_spaceposition = one_name.indexOf(' ');
		String one_firstname= one_name.substring(0,one_splitone_spaceposition);
		String one_surname= one_name.substring(one_splitone_spaceposition+1);

		System.out.print("Please enter your time for the first kilometer <mm:ss.sss>: ");
		String one_splitone = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the second kilometer <mm:ss.sss>: ");
		String one_splittwoend = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the five kilometer race <mm:ss.sss>: ");
		String one_splitthreeend = keyboard.nextLine();

		// Runner One, Split One Information

		int one_splitone_colonposition = one_splitone.indexOf(':');
		String one_splitone_minutes = one_splitone.substring(0,	one_splitone_colonposition);
		String one_splitone_seconds = one_splitone
				.substring((one_splitone_colonposition + 1));

		double one_splitone_minutesdouble = Double.parseDouble(one_splitone_minutes);
		double one_splitone_secondsdouble = Double.parseDouble(one_splitone_seconds);

		double one_splitone_totalseconds = (one_splitone_minutesdouble * SECONDS_IN_A_MINUTE)
				+ one_splitone_secondsdouble;

		// Runner One, End of Split Two Information

		int one_splittwoend_colonposition = one_splittwoend.indexOf(':');
		String one_splittwoend_minutes = one_splittwoend.substring(0,one_splittwoend_colonposition);
		String one_splittwoend_seconds = one_splittwoend.substring((one_splittwoend_colonposition + 1));

		double one_splittwoend_minutesdouble = Double
				.parseDouble(one_splittwoend_minutes);
		double one_splittwoend_secondsdouble = Double
				.parseDouble(one_splittwoend_seconds);

		double one_splittwoend_totalseconds = (one_splittwoend_minutesdouble * SECONDS_IN_A_MINUTE)
				+ one_splittwoend_secondsdouble;

		// Runner One, Split Two Information

		double one_splittwo_totalseconds = one_splittwoend_totalseconds
				- one_splitone_totalseconds;
		int one_splittwo_minutes = (int) (one_splittwo_totalseconds / SECONDS_IN_A_MINUTE);
		
		//Formats the number of seconds so that the seconds digit has two numbers and the decimal has three digits
		DecimalFormat formatter_one = new DecimalFormat("#00.000");     
		String one_splittwo_seconds = formatter_one.format(one_splittwo_totalseconds % SECONDS_IN_A_MINUTE);
	
		// Runner One, End of Split Two Information

		int one_splitthreeend_colonposition = one_splitthreeend.indexOf(':');
		String one_splitthreeend_minutes = one_splitthreeend.substring(0,
				one_splitthreeend_colonposition);
		String one_splitthreeend_seconds = one_splitthreeend
				.substring((one_splitthreeend_colonposition + 1));

		double one_splitthreend_minutesdouble = Double
				.parseDouble(one_splitthreeend_minutes);
		double one_splitthreeend_secondsdouble = Double
				.parseDouble(one_splitthreeend_seconds);

		double one_splitthreeend_totalseconds = (one_splitthreend_minutesdouble * SECONDS_IN_A_MINUTE)
				+ one_splitthreeend_secondsdouble;

		// Runner One, Split Three Information

		double one_splitthree_totalseconds = one_splitthreeend_totalseconds
				- (one_splittwo_totalseconds+one_splitone_totalseconds);
		int one_splitthree_minutes = (int) (one_splitthree_totalseconds / SECONDS_IN_A_MINUTE);
	 
		String one_splitthree_seconds = formatter_one.format(one_splitthree_totalseconds % SECONDS_IN_A_MINUTE);
		
		// Print all of Runner One's information
		
		System.out.println("");
		System.out.println("");
		System.out.println("Runner One");
		System.out.println("******************************");
		System.out.println("Name: " + one_surname + ", " + one_firstname);  
		System.out.println("Split One: " + one_splitone);
		System.out.println("Split Two: " + one_splittwo_minutes + ":" +  one_splittwo_seconds);
		System.out.println("Split Three: " + one_splitthree_minutes + ":" + one_splitthree_seconds);
		System.out.println("Total Time: " + one_splitthreeend);
		System.out.println("");
		System.out.println("");
		
		
		/*RUNNER TWO---RUNNER TWO---RUNNER TWO---RUNNER TWO---RUNNER TWO---RUNNER TWO---RUNNER TWO*/
		
		// Requests all information for the second runner
		// two_ is the prefix for all the second runner's info)

		System.out.println("SECOND RUNNER");

		System.out.print("Please enter your first and last name: ");
		String two_name = keyboard.nextLine();
				
		int two_splitone_spaceposition = two_name.indexOf(' ');
		String two_firstname= two_name.substring(0,two_splitone_spaceposition);
		String two_surname= two_name.substring(two_splitone_spaceposition+1);

		System.out.print("Please enter your time for the first kilometer <mm:ss.sss>: ");
		String two_splitone = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the second kilometer <mm:ss.sss>: ");
		String two_splittwoend = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the five kilometer race <mm:ss.sss>: ");
		String two_splitthreeend = keyboard.nextLine();

		// Runner Two, Split One Information

		int two_splitone_colonposition = two_splitone.indexOf(':');
		String two_splitone_minutes = two_splitone.substring(0,	two_splitone_colonposition);
		String two_splitone_seconds = two_splitone.substring((two_splitone_colonposition + 1));

		double two_splitone_minutesdouble = Double.parseDouble(two_splitone_minutes);
		double two_splitone_secondsdouble = Double.parseDouble(two_splitone_seconds);

		double two_splitone_totalseconds = (two_splitone_minutesdouble * SECONDS_IN_A_MINUTE)+ two_splitone_secondsdouble;

		// Runner Two, End of Split Two Information

		int two_splittwoend_colonposition = two_splittwoend.indexOf(':');
		String two_splittwoend_minutes = two_splittwoend.substring(0,two_splittwoend_colonposition);
		String two_splittwoend_seconds = two_splittwoend.substring((two_splittwoend_colonposition + 1));

		double two_splittwoend_minutesdouble = Double.parseDouble(two_splittwoend_minutes);
		double two_splittwoend_secondsdouble = Double.parseDouble(two_splittwoend_seconds);

		double two_splittwoend_totalseconds = (two_splittwoend_minutesdouble * SECONDS_IN_A_MINUTE)+ two_splittwoend_secondsdouble;

		// Runner Two, Split Two Information

		double two_splittwo_totalseconds = two_splittwoend_totalseconds	- two_splitone_totalseconds;
		int two_splittwo_minutes = (int) (two_splittwo_totalseconds / SECONDS_IN_A_MINUTE);
		String two_splittwo_seconds = formatter_one.format(two_splittwo_totalseconds % SECONDS_IN_A_MINUTE);
			
		// Runner Two, End of Split Three Information

		int two_splitthreeend_colonposition = two_splitthreeend.indexOf(':');
		String two_splitthreeend_minutes = two_splitthreeend.substring(0,two_splitthreeend_colonposition);
		String two_splitthreeend_seconds = two_splitthreeend.substring(two_splitthreeend_colonposition + 1);

		double two_splitthreend_minutesdouble = Double.parseDouble(two_splitthreeend_minutes);
		double two_splitthreeend_secondsdouble = Double.parseDouble(two_splitthreeend_seconds);

		double two_splitthreeend_totalseconds = (two_splitthreend_minutesdouble * SECONDS_IN_A_MINUTE)+ two_splitthreeend_secondsdouble;

		// Runner Two, Split Three Information

		double two_splitthree_totalseconds = two_splitthreeend_totalseconds - (two_splittwo_totalseconds+two_splitone_totalseconds);
		int two_splitthree_minutes = (int) (two_splitthree_totalseconds / SECONDS_IN_A_MINUTE);
			 
		String two_splitthree_seconds = formatter_one.format(two_splitthree_totalseconds % SECONDS_IN_A_MINUTE);
				
		// Print all of Runner Two's information
			
		System.out.println("");
		System.out.println("");
		System.out.println("Runner Two");
		System.out.println("******************************");
		System.out.println("Name: " + two_surname + ", " + two_firstname);  
		System.out.println("Split One: " + two_splitone);
		System.out.println("Split Two: " + two_splittwo_minutes + ":" +  two_splittwo_seconds);
		System.out.println("Split Three: " + two_splitthree_minutes + ":" + two_splitthree_seconds);
		System.out.println("Total Time: " + two_splitthreeend);
		System.out.println("");
		System.out.println("");		
		
		
		/*RUNNER THREE---RUNNER THREE---RUNNER THREE---RUNNER THREE---RUNNER THREE---RUNNER THREE---RUNNER THREE*/
		
		// Requests all information for the third runner
		// three_ is the prefix for all the third runner's info)

		System.out.println("THIRD RUNNER");

		System.out.print("Please enter your first and last name: ");
		String three_name = keyboard.nextLine();
				
		int three_splitone_spaceposition = three_name.indexOf(' ');
		String three_firstname= three_name.substring(0,three_splitone_spaceposition);
		String three_surname= three_name.substring(three_splitone_spaceposition+1);

		System.out.print("Please enter your time for the first kilometer <mm:ss.sss>: ");
		String three_splitone = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the second kilometer <mm:ss.sss>: ");
		String three_splittwoend = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the five kilometer race <mm:ss.sss>: ");
		String three_splitthreeend = keyboard.nextLine();

		// Runner Three, Split One Information

		int three_splitone_colonposition = three_splitone.indexOf(':');
		String three_splitone_minutes = three_splitone.substring(0,	three_splitone_colonposition);
		String three_splitone_seconds = three_splitone.substring((three_splitone_colonposition + 1));

		double three_splitone_minutesdouble = Double.parseDouble(three_splitone_minutes);
		double three_splitone_secondsdouble = Double.parseDouble(three_splitone_seconds);

		double three_splitone_totalseconds = (three_splitone_minutesdouble * SECONDS_IN_A_MINUTE)+ three_splitone_secondsdouble;

		// Runner Three, End of Split Two Information

		int three_splittwoend_colonposition = three_splittwoend.indexOf(':');
		String three_splittwoend_minutes = three_splittwoend.substring(0,three_splittwoend_colonposition);
		String three_splittwoend_seconds = three_splittwoend.substring((three_splittwoend_colonposition + 1));

		double three_splittwoend_minutesdouble = Double.parseDouble(three_splittwoend_minutes);
		double three_splittwoend_secondsdouble = Double.parseDouble(three_splittwoend_seconds);

		double three_splittwoend_totalseconds = (three_splittwoend_minutesdouble * SECONDS_IN_A_MINUTE)+ three_splittwoend_secondsdouble;

		// Runner Three, Split Two Information

		double three_splittwo_totalseconds = three_splittwoend_totalseconds - three_splitone_totalseconds;
		int three_splittwo_minutes = (int) (three_splittwo_totalseconds / SECONDS_IN_A_MINUTE);
		String three_splittwo_seconds = formatter_one.format(three_splittwo_totalseconds % SECONDS_IN_A_MINUTE);
			
		// Runner Three, End of Split Three Information

		int three_splitthreeend_colonposition = three_splitthreeend.indexOf(':');
		String three_splitthreeend_minutes = three_splitthreeend.substring(0,three_splitthreeend_colonposition);
		String three_splitthreeend_seconds = three_splitthreeend.substring(three_splitthreeend_colonposition + 1);

		double three_splitthreend_minutesdouble = Double.parseDouble(three_splitthreeend_minutes);
		double three_splitthreeend_secondsdouble = Double.parseDouble(three_splitthreeend_seconds);

		double three_splitthreeend_totalseconds = (three_splitthreend_minutesdouble * SECONDS_IN_A_MINUTE)+ three_splitthreeend_secondsdouble;

		// Runner Three, Split Three Information

		double three_splitthree_totalseconds = three_splitthreeend_totalseconds - (three_splittwo_totalseconds+three_splitone_totalseconds);
		int three_splitthree_minutes = (int) (three_splitthree_totalseconds / SECONDS_IN_A_MINUTE);
			 
		String three_splitthree_seconds = formatter_one.format(three_splitthree_totalseconds % SECONDS_IN_A_MINUTE);
				
		// Print all of Runner Three's information
		
		System.out.println("");
		System.out.println("");
		System.out.println("Runner Three");
		System.out.println("******************************");
		System.out.println("Name: " + three_surname + ", " + three_firstname);  
		System.out.println("Split One: " + three_splitone);
		System.out.println("Split Two: " + three_splittwo_minutes + ":" +  three_splittwo_seconds);
		System.out.println("Split Three: " + three_splitthree_minutes + ":" + three_splitthree_seconds);
		System.out.println("Total Time: " + three_splitthreeend);
		System.out.println("");
		System.out.println("");
		
		
/*RUNNER FOUR---RUNNER FOUR---RUNNER FOUR---RUNNER FOUR---RUNNER FOUR---RUNNER FOUR---RUNNER FOUR*/
		
		// Requests all information for the fourth runner
		// four_ is the prefix for all the fourth runner's info)

		System.out.println("FOURTH RUNNER");

		System.out.print("Please enter your first and last name: ");
		String four_name = keyboard.nextLine();
				
		int four_splitone_spaceposition = four_name.indexOf(' ');
		String four_firstname= four_name.substring(0,four_splitone_spaceposition);
		String four_surname= four_name.substring(four_splitone_spaceposition+1);

		System.out.print("Please enter your time for the first kilometer <mm:ss.sss>: ");
		String four_splitone = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the second kilometer <mm:ss.sss>: ");
		String four_splittwoend = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the five kilometer race <mm:ss.sss>: ");
		String four_splitthreeend = keyboard.nextLine();

		// Runner Four, Split One Information

		int four_splitone_colonposition = four_splitone.indexOf(':');
		String four_splitone_minutes = four_splitone.substring(0,	four_splitone_colonposition);
		String four_splitone_seconds = four_splitone.substring((four_splitone_colonposition + 1));

		double four_splitone_minutesdouble = Double.parseDouble(four_splitone_minutes);
		double four_splitone_secondsdouble = Double.parseDouble(four_splitone_seconds);

		double four_splitone_totalseconds = (four_splitone_minutesdouble * SECONDS_IN_A_MINUTE)+ four_splitone_secondsdouble;

		// Runner Four, End of Split Two Information

		int four_splittwoend_colonposition = four_splittwoend.indexOf(':');
		String four_splittwoend_minutes = four_splittwoend.substring(0,four_splittwoend_colonposition);
		String four_splittwoend_seconds = four_splittwoend.substring((four_splittwoend_colonposition + 1));

		double four_splittwoend_minutesdouble = Double.parseDouble(four_splittwoend_minutes);
		double four_splittwoend_secondsdouble = Double.parseDouble(four_splittwoend_seconds);

		double four_splittwoend_totalseconds = (four_splittwoend_minutesdouble * SECONDS_IN_A_MINUTE)+ four_splittwoend_secondsdouble;

		// Runner Four, Split Two Information

		double four_splittwo_totalseconds = four_splittwoend_totalseconds - four_splitone_totalseconds;
		int four_splittwo_minutes = (int) (four_splittwo_totalseconds / SECONDS_IN_A_MINUTE);
		String four_splittwo_seconds = formatter_one.format(four_splittwo_totalseconds % SECONDS_IN_A_MINUTE);
			
		// Runner Four, End of Split Three Information

		int four_splitthreeend_colonposition = four_splitthreeend.indexOf(':');
		String four_splitthreeend_minutes = four_splitthreeend.substring(0,four_splitthreeend_colonposition);
		String four_splitthreeend_seconds = four_splitthreeend.substring(four_splitthreeend_colonposition + 1);

		double four_splitthreend_minutesdouble = Double.parseDouble(four_splitthreeend_minutes);
		double four_splitthreeend_secondsdouble = Double.parseDouble(four_splitthreeend_seconds);

		double four_splitthreeend_totalseconds = (four_splitthreend_minutesdouble * SECONDS_IN_A_MINUTE)+ four_splitthreeend_secondsdouble;

		// Runner four, Split Three Information

		double four_splitthree_totalseconds = four_splitthreeend_totalseconds - (four_splittwo_totalseconds+four_splitone_totalseconds);
		int four_splitthree_minutes = (int) (four_splitthree_totalseconds / SECONDS_IN_A_MINUTE);
			 
		String four_splitthree_seconds = formatter_one.format(four_splitthree_totalseconds % SECONDS_IN_A_MINUTE);
				
				
		// Print all of Runner Four's information
		
		System.out.println("");
		System.out.println("");
		System.out.println("Runner Four");
		System.out.println("******************************");
		System.out.println("Name: " + four_surname + ", " + four_firstname);  
		System.out.println("Split One: " + four_splitone);
		System.out.println("Split Two: " + four_splittwo_minutes + ":" +  four_splittwo_seconds);
		System.out.println("Split Three: " + four_splitthree_minutes + ":" + four_splitthree_seconds);
		System.out.println("Total Time: " + four_splitthreeend);
		System.out.println("");
		System.out.println("");
		
		/*RUNNER FIVE---RUNNER FIVE---RUNNER FIVE---RUNNER FIVE---RUNNER FIVE---RUNNER FIVE---RUNNER FIVE*/
		
		// Requests all information for the fifth runner
		// five_ is the prefix for all the fifth runner's info)

		System.out.println("FIFTH RUNNER");

		System.out.print("Please enter your first and last name: ");
		String five_name = keyboard.nextLine();
				
		int five_splitone_spaceposition = five_name.indexOf(' ');
		String five_firstname= five_name.substring(0,five_splitone_spaceposition);
		String five_surname= five_name.substring(five_splitone_spaceposition+1);

		System.out.print("Please enter your time for the first kilometer <mm:ss.sss>: ");
		String five_splitone = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the second kilometer <mm:ss.sss>: ");
		String five_splittwoend = keyboard.nextLine();

		System.out.print("Please enter your time at the end of the five kilometer race <mm:ss.sss>: ");
		String five_splitthreeend = keyboard.nextLine();

		// Runner Five, Split One Information

		int five_splitone_colonposition = five_splitone.indexOf(':');
		String five_splitone_minutes = five_splitone.substring(0,	five_splitone_colonposition);
		String five_splitone_seconds = five_splitone.substring((five_splitone_colonposition + 1));

		double five_splitone_minutesdouble = Double.parseDouble(five_splitone_minutes);
		double five_splitone_secondsdouble = Double.parseDouble(five_splitone_seconds);

		double five_splitone_totalseconds = (five_splitone_minutesdouble * SECONDS_IN_A_MINUTE)+ five_splitone_secondsdouble;

		// Runner Five, End of Split Two Information

		int five_splittwoend_colonposition = five_splittwoend.indexOf(':');
		String five_splittwoend_minutes = five_splittwoend.substring(0,five_splittwoend_colonposition);
		String five_splittwoend_seconds = five_splittwoend.substring((five_splittwoend_colonposition + 1));

		double five_splittwoend_minutesdouble = Double.parseDouble(five_splittwoend_minutes);
		double five_splittwoend_secondsdouble = Double.parseDouble(five_splittwoend_seconds);

		double five_splittwoend_totalseconds = (five_splittwoend_minutesdouble * SECONDS_IN_A_MINUTE)+ five_splittwoend_secondsdouble;

		// Runner Five, Split Two Information

		double five_splittwo_totalseconds = five_splittwoend_totalseconds - five_splitone_totalseconds;
		int five_splittwo_minutes = (int) (five_splittwo_totalseconds / SECONDS_IN_A_MINUTE);
		String five_splittwo_seconds = formatter_one.format(five_splittwo_totalseconds % SECONDS_IN_A_MINUTE);
			
		// Runner Five, End of Split Three Information

		int five_splitthreeend_colonposition = five_splitthreeend.indexOf(':');
		String five_splitthreeend_minutes = five_splitthreeend.substring(0,five_splitthreeend_colonposition);
		String five_splitthreeend_seconds = five_splitthreeend.substring(five_splitthreeend_colonposition + 1);

		double five_splitthreend_minutesdouble = Double.parseDouble(five_splitthreeend_minutes);
		double five_splitthreeend_secondsdouble = Double.parseDouble(five_splitthreeend_seconds);

		double five_splitthreeend_totalseconds = (five_splitthreend_minutesdouble * SECONDS_IN_A_MINUTE)+ five_splitthreeend_secondsdouble;

		// Runner Five, Split Three Information

		double five_splitthree_totalseconds = five_splitthreeend_totalseconds - (five_splittwo_totalseconds+five_splitone_totalseconds);
		int five_splitthree_minutes = (int) (five_splitthree_totalseconds / SECONDS_IN_A_MINUTE);
			 
		String five_splitthree_seconds = formatter_one.format(five_splitthree_totalseconds % SECONDS_IN_A_MINUTE);
				
		// Print all of Runner Five's information
		
		System.out.println("");
		System.out.println("");
		System.out.println("Runner Five");
		System.out.println("******************************");
		System.out.println("Name: " + five_surname + ", " + five_firstname);  
		System.out.println("Split One: " + five_splitone);
		System.out.println("Split Two: " + five_splittwo_minutes + ":" +  five_splittwo_seconds);
		System.out.println("Split Three: " + five_splitthree_minutes + ":" + five_splitthree_seconds);
		System.out.println("Total Time: " + five_splitthreeend);
		System.out.println("");
		System.out.println("");

		
		//Reverses names and puts surnames before the first name
		
		String one_reversedname= (one_surname + ", " + one_firstname);
		String two_reversedname= (two_surname + ", " + two_firstname);
		String three_reversedname= (three_surname + ", " + three_firstname);
		String four_reversedname= (four_surname + ", " + four_firstname);
		String five_reversedname= (five_surname + ", " + five_firstname);
		
		
		
		
		/*FINAL SUMMARY TABLE----FINAL SUMMARY TABLE----FINAL SUMMARY TABLE*/
		
		System.out.println("FINAL SUMMARY TABLE");
		
		System.out.printf("\n%20s%20s%20s%20s%20s", "Runner", "Split One","Split Two", "Split Three", "Final Time");
		System.out.printf("\n%20s%20s%20s%20s%20s", one_reversedname, one_splitone, (one_splittwo_minutes+":"+one_splittwo_seconds), 
				(one_splitthree_minutes + ":" + one_splitthree_seconds), one_splitthreeend);
		System.out.printf("\n%20s%20s%20s%20s%20s", two_reversedname, two_splitone, (two_splittwo_minutes+":"+two_splittwo_seconds), 
				(two_splitthree_minutes + ":" + two_splitthree_seconds), two_splitthreeend);
		System.out.printf("\n%20s%20s%20s%20s%20s", three_reversedname, three_splitone, (three_splittwo_minutes+":"+three_splittwo_seconds), 
				(three_splitthree_minutes + ":" + three_splitthree_seconds), three_splitthreeend);
		System.out.printf("\n%20s%20s%20s%20s%20s", four_reversedname, four_splitone, (four_splittwo_minutes+":"+four_splittwo_seconds), 
				(four_splitthree_minutes + ":" + four_splitthree_seconds), four_splitthreeend);
		System.out.printf("\n%20s%20s%20s%20s%20s", five_reversedname, five_splitone, (five_splittwo_minutes+":"+five_splittwo_seconds), 
				(five_splitthree_minutes + ":" + five_splitthree_seconds), five_splitthreeend);
	
		//Allows the user to view the table before closing the program
		System.out.println("\n");
		System.out.println("\n Please press the enter key to complete the program ");
		String finished = keyboard.nextLine();
		
		
		//Gets rid of the warning related to unused strings
		System.out.println(finished);
		
		
		
		
		keyboard.close();

	}

}
