/*
 * Name: Justin Borromeo
 * Course: ICS3U-AP
 * Title: Blackjack Assignment
 * Description: Blackjack Assignment
 * Due Date: December 12, 2014
 * Teacher: Mr. Deslauriers
 */
package com.bayviewglen.blackjack;

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class BlackjackAssignment {

    // Initialize all of the global variables

    public static String card;
    public static String[] allplayercardsstring = new String[21];
    public static int[] allplayercardsvalue = new int[21];
    public static String[] alldealercardsstring = new String[21];
    public static int[] alldealercardsvalue = new int[21];
    public static int playerdealcount;
    public static int dealerdealcount;
    public static int bank = 500;
    public static String betstring;
    public static int betint;
    public static int playersubtotal;
    public static int dealersubtotal;
    public static Scanner keyboard = new Scanner(System.in);
    public static boolean doubledown;
    public static String choicestring;
    public static int choiceint;
    public static boolean playerdoneplaying;
    public static boolean overalldoneplaying;
    public static boolean stop;
    public static boolean playerbust = false;
    public static boolean dealerbust = false;
    public static boolean playerwin = false;
    public static boolean dealerwin = false;
    public static String playername;
    public static String doneplaying;
    public static boolean validinput;
    public static String localestring;
    public static int localeint;
    public static boolean autowinblackjack;
    public static boolean push;

    public static void main(String[] args) throws InterruptedException {
        //Introduction to the game

        System.out.println("Welcome to Blackjack");
        Thread.sleep(1000);
        System.out.println("By: Justin Borromeo");
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("Important Notes:");
        System.out.println("");
        Thread.sleep(1000);
        System.out.println("In the event of the player getting blackjack, the player automatically wins");
        Thread.sleep(1000);
        System.out.println("In the event of a tie (push), the player does not win or lose money");
        System.out.println("");
        Thread.sleep(1000);

        Locale locale = getlocale();
        NumberFormat currformat = NumberFormat.getCurrencyInstance(locale);

        while (!overalldoneplaying) {

            bank = 500;
            System.out
                .println("\nWhat is your name (if you want to end the program, enter done)?");
            playername = keyboard.nextLine();
            if (playername.equals("done") || playername.equals("Done") || playername.equals("DONE")) {
                playerdoneplaying = true;
                overalldoneplaying = true;
            } else {
                playerdoneplaying = false;
                overalldoneplaying = false;
            }
            // Gets bet
            while (!playerdoneplaying) {
                playerbust = false;
                dealerbust = false;
                playerdoneplaying = false;
                overalldoneplaying = false;
                stop = false;
                playersubtotal = 0;
                dealersubtotal = 0;
                playerdealcount = 0;
                dealerdealcount = 0;
                playerwin = false;
                dealerwin = false;
                doubledown = false;
                autowinblackjack = false;
                boolean donebet = false;

                //Try Catch

                while (!donebet) {
                    validinput = false;
                    System.out.println("You have " + currformat.format(bank) + " in the bank.");
                    Thread.sleep(1000);
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
                    } else if (betint > bank) {
                        System.out.println("You do not have that much money!");
                        donebet = false;
                    } else {
                        System.out.println("That is an acceptable bet!");
                        donebet = true;
                    }
                }
                Thread.sleep(1000);
                // Deals Two Cards To The Player
                playerdealcards();
                System.out.println("Card #" + playerdealcount + " for " + playername + " is " + allplayercardsstring[playerdealcount]);
                playerdealcards();
                Thread.sleep(1000);
                System.out.println("Card #" + playerdealcount + " for " + playername + " is " + allplayercardsstring[playerdealcount]);
                Thread.sleep(1000);
                System.out.println("You have a total of " + playersubtotal);
                /*
                 * If the player's total is 21 (or blackjack), boolean variable autowinblackjack is true and the rest of the round is
                 * skipped up to the point where it announces the results and calculates the change of the bank account
                 */
                if (playersubtotal == 21) {
                    playerwin = true;
                    autowinblackjack = true;
                }
                if (!autowinblackjack) {
                    // Deals Two Cards To The Dealer

                    if (!playerwin) {
                        dealerdealcards();
                        Thread.sleep(1000);
                        System.out.println("\nCard #" + dealerdealcount + " for the dealer is " + alldealercardsstring[dealerdealcount]);

                        dealerdealcards();
                        Thread.sleep(1000);
                        System.out.println("Card #" + dealerdealcount + " for the dealer is lying facedown");
                        Thread.sleep(1000);
                    }

                    // Allows user to hit, stand, or stay
                    if (!playerwin) {
                        while (!stop && !playerbust) {
                            choice();
                            playerhitstand(choiceint);
                        }
                    }

                    // Once the player stands, the dealer continues to hit until
                    // subtotal is more than 17 or dealersubtotal>playersubtotal
                    if (!playerwin) {
                        Thread.sleep(1000);
                        System.out.println("Card #" + dealerdealcount + " for the dealer is revealed to be a " + alldealercardsstring[dealerdealcount]);
                        Thread.sleep(1000);
                        System.out.println("The dealer has a total of " + dealersubtotal);
                    }

                    while (!playerbust && dealersubtotal < 17 && !dealerbust && dealersubtotal < playersubtotal) {
                        dealerdealcards();
                        Thread.sleep(1000);
                        System.out.println("Card #" + dealerdealcount + " for the dealer is " + alldealercardsstring[dealerdealcount]);
                        Thread.sleep(1000);
                        System.out.println("The dealer has a total of " + dealersubtotal);

                        if (dealersubtotal > 21) {
                            dealerbust = true;
                            Thread.sleep(1000);
                            System.out.println("The dealer has busted!!! You have won!");
                            playerwin = true;
                        }
                    }
                }
                // The program compares the dealer's total and the player's
                // total and decides who won
                push = false;
                System.out.println("");
                if (!playerbust && !dealerbust) {
                    if (autowinblackjack) {
                        System.out.println("Congratulations, " + playername + ", you have won by getting Blackjack!!!");
                        playerwin = true;
                        dealerwin = false;
                        // A push is a tie and no one wins or loses money in the round        
                    } else if (playersubtotal == dealersubtotal) {
                        System.out.println("This is a push, you and the dealer have the same total!!!");
                        System.out.println("You do not win or lose money on this hand!!!");
                        push = true;
                    } else if (playersubtotal > dealersubtotal) {
                        System.out.println("Congratulations, " + playername + ", you have won!!!");
                        playerwin = true;
                        dealerwin = false;
                    } else {
                        System.out.println("Sorry " + playername + ", the dealer has won!!!");
                        dealerwin = true;
                        playerwin = false;
                    }
                }
                // The program decides whether to add the bet or subtract the
                // bet from the player's bank
                if (dealerwin) {
                    bank -= betint;
                    System.out
                        .println("You now have " + currformat.format(bank) + " in the bank.");
                } else if (playerwin) {
                    bank += betint;
                    System.out
                        .println("You now have " + currformat.format(bank) + " in the bank.");
                } else {
                    System.out.println("You now have " + currformat.format(bank) + " in the bank");
                }


                if (bank <= 0) {
                    System.out.println("Sorry you are broke.  You have lost!!!");
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
                            playerdoneplaying = true;
                            overalldoneplaying = true;
                        } else {
                            playerdoneplaying = false;
                            bank = 500;
                        }
                    }
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
                            playerdoneplaying = true;
                        } else {
                            playerdoneplaying = false;
                        }
                    }
                }
            }
        }
    }

    // METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS

    private static Locale getlocale() {

        Locale locale = null;

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


        validinput = false;
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

    private static void dealerdealcards() {

        dealerdealcount++;
        String[] suit = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };
        String[] rank = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
            "Queen", "King", "Ace"
        };

        int i = (int)(Math.random() * rank.length);
        int j = (int)(Math.random() * suit.length);
        card = (rank[i] + " of " + suit[j]);
        //stores the card in the array alldealercardsstring
        alldealercardsstring[dealerdealcount] = card;

        int value;
        if (i <= 8 && i >= 0) {
            value = i + 2;

            //calculates the value of the ace(s)    
        } else if (i == 12) {
            if (dealersubtotal <= 10) {
                value = 11;
            } else {
                value = 1;
            }
        } else {
            value = 10;
        }
        dealersubtotal += value;

    }

    private static void playerhitstand(int choice) throws InterruptedException {

        if (!playerbust) {
            if (choice == 1) {
                playerdealcards();
                System.out.println("Card #" + playerdealcount + " is " + allplayercardsstring[playerdealcount]);
                Thread.sleep(1000);
                System.out.println("You have a total of " + playersubtotal);
            } else if (choice == 2) {
                System.out.println("You have chosen to stand.");
                stop = true;
            } else {
                betint *= 2;
                playerdealcards();
                stop = true;
                System.out.println("Card # " + playerdealcount + " is " + allplayercardsstring[playerdealcount]);
                Thread.sleep(1000);
                System.out.println("You have a total of " + playersubtotal);
            }

            if (playersubtotal > 21) {
                playerbust = true;
                System.out.println("Sorry, you have busted!  Dealer wins!");
                dealerwin = true;
            }
        }
    }

    public static void playerdealcards() {
        //see annotations of dealerdealcards
        playerdealcount++;
        String[] suit = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };
        String[] rank = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
            "Queen", "King", "Ace"
        };

        int i = (int)(Math.random() * rank.length);
        int j = (int)(Math.random() * suit.length);
        card = (rank[i] + " of " + suit[j]);
        allplayercardsstring[playerdealcount] = card;

        int value;
        if (i <= 8 && i >= 0) {
            value = i + 2;
        } else if (i == 12) {
            if (playersubtotal <= 10) {
                value = 11;
            } else {
                value = 1;
            }
        } else {
            value = 10;
        }
        playersubtotal += value;
    }

    private static void choice() throws InterruptedException {
        System.out.println("What would you like to do now?");
        Thread.sleep(1000);
        choicestring = null;
        choiceint = 0;
        //if 2 times betint is less than bank 
        if ((2 * betint) <= bank || doubledown) {
            validinput = false;
            while (!validinput) {
                System.out.println("1: Hit, 2: Stand, 3: Double Down");
                String choicestring = keyboard.nextLine();

                try {
                    choiceint = Integer.parseInt(choicestring);
                    validinput = true;
                } catch (NumberFormatException ex) {
                    System.out.println(choicestring + " is not a valid choice.");

                }
            }

            if (choiceint <= 0 || choiceint >= 4) {
                System.out.println("That is not a valid choice");
            } else {
                System.out.println("That is a valid choice");
            }
        } else {
            System.out.println("1: Hit, 2: Stand");
            choicestring = keyboard.nextLine();
            choiceint = Integer.parseInt(choicestring);
            if (choiceint <= 0 || choiceint >= 3) {
                System.out.println("That is not a valid choice");

            } else {
                System.out.println("That is a valid choice");
            }

        }

    }
}