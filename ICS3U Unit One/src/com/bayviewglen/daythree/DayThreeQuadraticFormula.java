package com.bayviewglen.daythree;

public class DayThreeQuadraticFormula {

	public static void main(String[] args) {

		double a = 1;
		double b = 10;
		double c = 4;
		double solutionone;
		double solutiontwo;

		solutionone = ((-1 * b) + (Math.sqrt((b * b) - (4 * a * c))) / (2 * a));
		solutiontwo = ((-1 * b) - (Math.sqrt((b * b) - (4 * a * c))) / (2 * a));

		System.out.println(solutionone);
		System.out.println(solutiontwo);

	}

}
