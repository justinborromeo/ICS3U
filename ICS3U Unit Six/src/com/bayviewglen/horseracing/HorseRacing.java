/*
 * Justin Borromeo
 * ICS3U
 * Horse Racing Assignment
 * Mr. Deslauriers
 * Due: February 6, 2015
 */
package com.bayviewglen.horseracing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HorseRacing {
    public static Scanner keyboard = new Scanner(System.in);
    public static boolean playagain = true;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

    	Locale locale=getLocale();
    	NumberFormat currformat = NumberFormat.getCurrencyInstance(locale);
    	
    	String[] horses = getHorses(); //Complete-Untested		

        String[] userswithwallet = getUsers(); //Complete-Untested

        String[] users = splitUsers(userswithwallet); //Complete-Untested

        int[] userswallet = splitWallet(userswithwallet); //Complete-Untested

        int usernumber = chooseUser(users, userswallet); //Incomplete-Untested

        String user = users[usernumber];
        System.out.println("Good day, " + user);

        int wallet = userswallet[usernumber];

        while (playagain) {

            int numhorsesinrace = chooseNumHorses(); //Complete-Tested

            String[] horsesinrace = randomizeHorsesInRace(numhorsesinrace, horses); //Sometimes gets two of the same horse

            int horsechoice = chooseHorse(horsesinrace); //Complete-Untested

            int bet = chooseBet(wallet, currformat); //Complete-Untested

            boolean horseracedone = false;

            int[] horsepositions = new int[horsesinrace.length];
            int count = 0;
            while (!horseracedone) {

                horsepositions = makeTimeSteps(horsesinrace, horsepositions); //Complete-Untested

                displayHorseRace(count, horsepositions, horseracedone, horsesinrace); //Complete-Untested
                count++;

                horseracedone = checkHorseRaceDone(horsepositions);
            }

            wallet = betResult(wallet, horsepositions, horsesinrace, horsechoice, bet, currformat);
            playagain = playAgain(wallet);
            if (wallet<=0){
            	 wallet=500;
            }    
            userswallet[usernumber]=wallet;
          
        }
        
        System.out.println("Thank you for playing!!!");
        saveGame(userswallet, users);

    }



	private static Locale getLocale() {
		 Locale locale = null;
		 Boolean validinput=false;
		 int localeint=0;
	        System.out.println("1. Canada");
	        System.out.println("2. French Canada");
	        System.out.println("3. China");
	        System.out.println("4. France");
	        System.out.println("5. Germany");
	        System.out.println("6. Italy");
	        System.out.println("7. Japan");
	        System.out.println("8. Korea");
	        System.out.println("9. UK");
	        System.out.println("10. USA");

	        //Checks the value of localeint to find the correct locale (according to the user's input)
	        while (!validinput) {
	            System.out.println("Please enter the number that corresponds to your location:");
	            String localestring = keyboard.nextLine();


	            try {
	                localeint = Integer.parseInt(localestring);
	                if (localeint == 1) {
	                    locale = Locale.CANADA;
	                    validinput = true;
	                } else if (localeint == 2) {
	                    locale = Locale.CANADA_FRENCH;
	                    validinput = true;
	                } else if (localeint == 3) {
	                    locale = Locale.CHINA;
	                    validinput = true;
	                } else if (localeint == 4) {
	                    locale = Locale.FRANCE;
	                    validinput = true;
	                } else if (localeint == 5) {
	                    locale = Locale.GERMANY;
	                    validinput = true;
	                } else if (localeint == 6) {
	                    locale = Locale.ITALY;
	                    validinput = true;
	                } else if (localeint == 7) {
	                    locale = Locale.JAPAN;
	                    validinput = true;
	                } else if (localeint == 8) {
	                    locale = Locale.KOREA;
	                    validinput = true;
	                } else if (localeint == 9) {
	                    locale = Locale.UK;
	                    validinput = true;
	                } else if (localeint == 10) {
	                    locale = Locale.US;
	                    validinput = true;
	                } else {
	                    System.out.println(localestring + " is not a valid input.");
	                }
	                System.out.println("Your locale is: " + locale);
	            } catch (NumberFormatException ex) {
	                System.out.println(localestring + " is not a valid input.");

	            }
	        }
	        return locale;
	}



	private static boolean checkHorseRaceDone(int[] horsepositions) {
        boolean done = false;

        for (int i = 0; i < horsepositions.length; i++) {
            if (horsepositions[i] == 50) {
                done = true;
            }
        }

        return done;
    }

    private static int betResult(int wallet, int[] horsepositions, String[] horsesinrace, int horsechoice, int bet, NumberFormat currformat) {
        int winninghorsenumber = 0;
        for (int i = 0; i < horsepositions.length; i++) {
            if (horsepositions[i] == 50) {
                winninghorsenumber = i;
            }
        }

        System.out.println("The winning horse is " + horsesinrace[winninghorsenumber]);

        if (horsechoice == winninghorsenumber) {
            System.out.println("Congratulations, you have won!!!");
            wallet += bet;
        } else {
            System.out.println("Sorry, you have lost!!!");
            wallet -= bet;
        }
        System.out.println("You now have " + currformat.format(wallet) + " in the bank");
        return wallet;
    }

    private static String[] randomizeHorsesInRace(int numHorses, String[] horses) {
        String[] horsesinracestring = new String[numHorses];
        int randomnumber = 0;
        boolean validnumber = false;
        String horse = null;
        for (int i = 0;i < numHorses; i++) {
            validnumber = false;
            while (!validnumber) {
                randomnumber = (int)(Math.random() * horses.length - 1);
                horse = horses[randomnumber];
                horsesinracestring[i] = horse;
                if (horsesinracestring[i].equalsIgnoreCase(horse)) {
                    validnumber = true;
                }
            }

        }
        return horsesinracestring;
    }

    private static int chooseNumHorses() {

        boolean validint = false;
        boolean withinrange = false;
        int numhorsesint = 0;
        String numhorsesstring = null;
        while (!validint || !withinrange) {
            System.out.println("How many horses are in your race (between 5 and 8)?");
            numhorsesstring = keyboard.nextLine();
            try {
                numhorsesint = Integer.parseInt(numhorsesstring);
                validint = true;
                if (numhorsesint <= 8 && numhorsesint >= 5) {
                    withinrange = true;
                } else {
                    System.out.println(numhorsesint + " is not within the given range.");
                    withinrange = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("You cannot have \"" + numhorsesstring + "\" horses.");
            }
        }
        return numhorsesint;
    }

    private static int[] splitWallet(String[] userswithwallet) {
        int[] wallet = new int[userswithwallet.length];
        for (int i = 0; i < userswithwallet.length; i++) {
            String userwithwallet = userswithwallet[i];
            int space = userwithwallet.indexOf(" ");
            String walletstring = userwithwallet.substring(space + 1, userwithwallet.length());
            int walletint = Integer.parseInt(walletstring);
            wallet[i] = walletint;
        }
        return wallet;
    }

    private static String[] splitUsers(String[] userswithwallet) {

        String[] users = new String[userswithwallet.length];

        for (int i = 0; i < userswithwallet.length; i++) {
            String userwithwallet = userswithwallet[i];
            int space = userwithwallet.indexOf(" ");
            users[i] = userwithwallet.substring(0, space);
        }
        return users;
    }

    public static String[] getHorses() {
        String[] horses = null;
        try {
            Scanner scanner = new Scanner(new File("input/horses.dat"));
            int numHorses = Integer.parseInt(scanner.nextLine());
            horses = new String[numHorses];

            for (int i = 0; i < numHorses; i++) {
                horses[i] = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return horses;

    }

    private static String[] getUsers() {
        String[] userswithwallet = null;
        try {
            Scanner scanner = new Scanner(new File("input/playerData.dat"));
            int numUsers = Integer.parseInt(scanner.nextLine());
            userswithwallet = new String[numUsers];

            for (int i = 0; i < numUsers; i++) {
                userswithwallet[i] = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return userswithwallet;
    }

    private static int chooseUser(String[] users, int[] userswallet) {
        boolean validint = false;
        boolean withinrange = false;
        int userchoiceint = 0;
        while (!validint || !withinrange) {

            System.out.println("Which user are you (enter the corresponding number)?");
            System.out.println("   Name: Wallet");
            for (int i = 0; i < users.length; i++) {
                System.out.println(i + "." + " " + users[i] + ": " + userswallet[i]);
            }
            String userchoicestring = keyboard.nextLine();


            try {
                userchoiceint = Integer.parseInt(userchoicestring);
                validint = true;
            } catch (NumberFormatException ex) {
                System.out.println("There is no option for user \"" + userchoicestring + "\"");
            }

            if (userchoiceint <= users.length - 1 && userchoiceint >= 0) {
                withinrange = true;
            } else {
                System.out.println(userchoiceint + " is not within the given range.");
                withinrange = false;
            }
        }

        return userchoiceint;

    }

    private static int chooseHorse(String[] horsesinrace) {
        System.out.println("Which horse would you like to bet on (enter the corresponding number)?");
        for (int i = 0; i < horsesinrace.length; i++) {
            System.out.println(i + "." + " " + horsesinrace[i]);
        }
        String userchoicestring = keyboard.nextLine();
        int userchoiceint = 0;
        boolean validint = false;
        boolean withinrange = false;
        while (!validint || !withinrange) {
            try {
                userchoiceint = Integer.parseInt(userchoicestring);
                validint = true;
            } catch (NumberFormatException ex) {
                System.out.println("There is no option for horse \"" + userchoicestring + "\"");
            }

            if (userchoiceint <= horsesinrace.length && userchoiceint >= 0) {
                withinrange = true;
            } else {
                System.out.println(userchoiceint + " is not within the given range.");
                withinrange = false;
            }
        }
        System.out.println("You have chosen " + horsesinrace[userchoiceint]);
        return userchoiceint;

    }

    private static int chooseBet(int wallet, NumberFormat currformat) {
        boolean donebet = false;
        boolean validinput = false;
        int betint = 0;
        while (!donebet) {
            validinput = false;
            System.out.println("You have " + currformat.format(wallet) + " in your wallet.");
            while (!validinput) {
                System.out.println("How much would you like to bet in your local currency (no cents please)? ");
                String betstring = keyboard.nextLine();

                try {
                    betint = Integer.parseInt(betstring);
                    validinput = true;
                } catch (NumberFormatException ex) {
                    System.out.println(betstring + " is not an acceptable bet amount.");
                }
            }
            //Makes sure bet is not negative or greater than the player's bank account
            if (betint <= 0) {
                System.out.println("You cannot have a negative bet!");
                donebet = false;
            } else if (betint > wallet) {
                System.out.println("You do not have that much money!");
                donebet = false;
            } else {
                System.out.println("That is an acceptable bet!");
                donebet = true;
            }
        }

        return betint;


    }

    private static void saveGame(int[] userswallet, String[] users) throws FileNotFoundException {
    	
    	Writer writer = null;
    	int length=userswallet.length;
    	String lengthstring=String.valueOf(length);
    	try {
    	    writer = new BufferedWriter(new OutputStreamWriter(
    	          new FileOutputStream("input/playerData.dat"), "utf-8"));
    	    
    	    writer.write(lengthstring);
    	    for(int i=0;i<users.length; i++){
    	    	writer.write("\n");
    	    	writer.write(users[i] + " " + userswallet[i]);
    	    }
    	} catch (IOException ex) {
    	} finally {
    	   try {writer.close();} catch (Exception ex) {}
    	}

    }


	private static int[] makeTimeSteps(String[] horsesinrace, int[] horsepositions) {
        int[] timesteps = new int[horsesinrace.length];
        int step = 0;
        for (int i = 0; i < horsesinrace.length; i++) {
            step = (int)(Math.random() * 3 + 1);
            timesteps[i] = step;
            horsepositions[i] += timesteps[i];
            if (horsepositions[i] > 50) {
                horsepositions[i] = 50;
            }
        }

        return horsepositions;
    }

    private static void displayHorseRace(int count, int[] horsepositions, boolean horseracedone, String[] horsesinrace) throws InterruptedException {
        System.out.println("");
        System.out.println("Time: " + count + " seconds");
        System.out.println("");

        for (int i = 0; i < horsesinrace.length; i++) {
            System.out.println("________________________________________________________________________");
            System.out.print(horsesinrace[i]);
            int length = horsesinrace[i].length();
            int twentyminus = 20 - length;
            for (int j = 0; j < twentyminus; j++) {
                System.out.print(" ");
            }
            System.out.print("|");
            for (int j = 0; j < horsepositions[i]; j++) {
                System.out.print(" ");
            }
            System.out.println(i);
        }
        Thread.sleep(1000);
    }

    private static boolean playAgain(int wallet) {
        boolean validinput = false;
        boolean playagain = false;
        String doneplaying = null;
        if (wallet <= 0) {
            System.out.println("Sorry you are broke.  You have lost!!!");
            playagain = false;

        } else {

            validinput = false;
            while (!validinput) {

                System.out.println("Would you like to play again?  Type y or n.");
                doneplaying = keyboard.nextLine();
                try {
                    validinput = (doneplaying.equals("y")) || (doneplaying.equals("n"));
                } catch (NumberFormatException ex) {
                    System.out.println("You must type in y or n");
                }

                if (doneplaying.equals("n")) {
                    playagain = false;
                } else {
                    playagain = true;
                }
            }
        }
        return playagain;
    }
}