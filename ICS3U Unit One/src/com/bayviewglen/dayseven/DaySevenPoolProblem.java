//Pool Problem

/*
 * Bayview Glen Pools

Bayview Glen has decided it would be a good idea to start a new company manufacturing pools.  They have come to you as an expertise in software development to design and implement a solution for their invoicing tool.
The company will only sell in-ground pools that are rectangular with a liner.  All pools can have a shallow end and then a deep end.  With a gradual (or not so gradual slope) as the transition between the shallow and deep end.
The user will enter the following information:
1.	Length and width of the pool.
2.	Depth of both the shallow and deep end.
3.	The length of the transition between the shallow end and the deep end.
4.	The price of three different liners that they can get for the pool.
Calculations:
1.	The program will need to calculate the amount of water needed to keep the pool 90% full.
2.	The amount of liner needed to create the pool.
3.	The cost of the liner.

The program will display a table with the information from the seven bullets (user input and calculations).

 */

package com.bayviewglen.dayseven;

import java.util.Scanner;

public class DaySevenPoolProblem {

	public static void main(String[] args) {
		
		Scanner Scanner = new Scanner(System.in);
		
		// This section of the program takes the user's inputs about the pool's dimensions
		
		System.out.print("Please enter the width of the pool:  ");
		double poolWidth = Scanner.nextDouble();
		
		System.out.print("Please enter the length of the pool:  ");
		double poolLength = Scanner.nextDouble();
		
		
		
		
		System.out.print("Please enter the depth of the shallow end of the pool:  ");
		double shallowEndDepth = Scanner.nextDouble();
		
		System.out.print("Please enter the depth of the deep end of the pool:  ");
		double deepEndDepth = Scanner.nextDouble();
		
		
		
		System.out.print("Please enter the length of the transition:  ");
		double transitionLength = Scanner.nextDouble();
		
		
		
		System.out.print("Please enter the length of the shallow end:  ");
		double shallowEndLength =  Scanner.nextDouble();
		
		
		
		System.out.print("Please enter the price per square meter of the liner:  ");
		double linerPricePerSqM = Scanner.nextDouble();
		
		
		
		//This section calculates the volume of the pool
		
		double transitionTriangleArea = (0.5)*(transitionLength*(deepEndDepth-shallowEndDepth));
		
		double shallowArea=(shallowEndDepth*poolLength);
		
		double deepArea=((deepEndDepth-shallowEndDepth)*(poolLength-(transitionLength+shallowEndLength)));
		
		double totalVolume = ((deepArea+shallowArea+transitionTriangleArea)*poolWidth);
		
		
		System.out.println("The volume of water in the pool if it is 90% filled is " + (0.9*totalVolume) + " litres");
		
		//This section calculates the amount of liner needed
		
		double linerArea= (deepEndDepth*poolWidth) + (shallowEndDepth*poolWidth) + (2*(poolLength));
		
		
		Scanner.close();
		

	}

}
