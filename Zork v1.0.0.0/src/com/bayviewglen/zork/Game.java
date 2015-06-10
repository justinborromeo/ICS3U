package com.bayviewglen.zork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

class Game {
    private Parser parser;
    private Room currentRoom;
    private Player player=new Player("empty");
    private boolean dead;

    
    private Scanner keyboard=new Scanner(System.in);
    // This is a MASTER object that contains all of the rooms and is easily accessible.
    // The key will be the name of the room -> no spaces (Use all caps and underscore -> Great Room would have a key of GREAT_ROOM
    // In a hashmap keys are case sensitive.
    private HashMap<String, Room> masterRoomMap;
    
    private void initRooms(String fileName) throws Exception{
    	masterRoomMap = new HashMap<String, Room>();
    	Scanner roomScanner;
		try {
			HashMap<String, HashMap<String, String>> exits = new HashMap<String, HashMap<String, String>>();    
			roomScanner = new Scanner(new File(fileName));
			while(roomScanner.hasNext()){
				Room room = new Room();
				// Read the Name
				String roomName = roomScanner.nextLine();
				room.setRoomName(roomName.split(":")[1].trim());
				// Read the Description
				String roomDescription = roomScanner.nextLine();
				room.setDescription(roomDescription.split(":")[1].replaceAll("<br>", "\n").trim());
				// Read the Exits
				String roomExits = roomScanner.nextLine();
				// An array of strings in the format E-RoomName
				String[] rooms = roomExits.split(":")[1].split(",");
				HashMap<String, String> temp = new HashMap<String, String>(); 
				for (String s : rooms){
					temp.put(s.split("-")[0].trim(), s.split("-")[1]);
				}
				
				exits.put(roomName.substring(roomName.indexOf(" ")).trim().toUpperCase().replaceAll(" ",  "_"), temp);
				
				masterRoomMap.put(roomName.toUpperCase().substring(roomName.indexOf(":")+1).trim().replaceAll(" ",  "_"), room);
				// This puts the room we created (Without the exits in the masterMap)
				
				String itemsline=roomScanner.nextLine();
				String[] itemnames=itemsline.split(":")[1].trim().split(",");
				Inventory tempinv=new Inventory();
				for(String s: itemnames){
					Item temp2=new Item(s);
					tempinv.addItem(temp2);
				}
				masterRoomMap.get(roomName.toUpperCase().substring(roomName.indexOf(":")+1).trim().replaceAll(" ",  "_")).setInventory(tempinv);	
				
				String lockedline=roomScanner.nextLine();
				String locked=lockedline.split(":")[1].trim();
				if(locked.toUpperCase().equals("YES")){
				masterRoomMap.get(roomName.toUpperCase().substring(roomName.indexOf(":")+1).trim().replaceAll(" ", "_")).setLocked(true);
				String keyname = roomScanner.nextLine().split(":")[1].trim();
				masterRoomMap.get(roomName.toUpperCase().substring(roomName.indexOf(":")+1).trim().replaceAll(" ", "_")).setKeyname(keyname);
				}
					
				
				
				// Now we better set the exits.
			}
			
			for (String key : masterRoomMap.keySet()){
				Room roomTemp = masterRoomMap.get(key);
				HashMap<String, String> tempExits = exits.get(key);
				for (String s : tempExits.keySet()){
					// s = direction
					// value is the room.
					
					String roomName2 = tempExits.get(s.trim());
					Room exitRoom = masterRoomMap.get(roomName2.toUpperCase().replaceAll(" ", "_"));
					roomTemp.setExit(s.trim().charAt(0), exitRoom);
					
				}
				
				
			}
    	
			roomScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }    

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        try {
			initRooms("data/Rooms.dat");
			currentRoom = masterRoomMap.get("COURTYARD_SOUTH");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        parser = new Parser();
    }

    

    /**
     *  Main play routine.  Loops until end of play.
     * @throws InterruptedException 
     */
    public void play() throws InterruptedException 
    {   
    	System.out.println("What is your name?");
    	String name=keyboard.nextLine();
    	player.setName(name);
    	printWelcome();
        

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished)
        {
        	 if(dead)
             	break;
           	Command command=parser.getCommand();
            finished = processCommand(command);
            System.out.println();
            if (!(currentRoom.isBeenhere())&&!dead){
                System.out.println(currentRoom.longDescription());
            }else if(!dead){
                System.out.println(currentRoom.getRoomName());
            }else{
            	break;
            }
            
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Hello " + player.getName() + " and welcome to Zork!!!  Zork is an incredibly fun adventure game programmed by Shon and Justin.");
        System.out.println("If you ever need help while playing the game, type in 'help'.  Now, press Enter to continue.");
        String useless = keyboard.nextLine();
        System.out.println();
        if (!(currentRoom.isBeenhere()))
            System.out.println(currentRoom.longDescription());
        else
            System.out.println(currentRoom.getRoomName());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) throws InterruptedException {
        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();

        if (commandWord.equals("help")) {
            printHelp();
            currentRoom.setBeenhere(true);
        } else if (commandWord.equals("go")) {
            goRoom(command);
            currentRoom.setBeenhere(true);
        } else if (commandWord.equals("take")) {
            if (currentRoom.getInventory().contains(secondWord)) {
                Inventory tempinventory = player.getPlayerInv();
                Inventory currentroominventory = currentRoom.getInventory();
                Item toTake = currentroominventory.getItem(secondWord);
                currentroominventory.removeItem(toTake);
                tempinventory.addItem(toTake);
                player.setPlayerInv(tempinventory);
                System.out.println("Taken!");
                currentRoom.setBeenhere(true);
            } else if (commandWord.equals("drop")) {

            } else {
                System.out.println("There are no " + secondWord + "s at this location!");
                currentRoom.setBeenhere(true);
            }
        } else if (commandWord.equals("inv")) {
            //PrintInventory
        	System.out.println("Your invenvtory:");
        	player.getPlayerInv().print();   
        	
        } else if (commandWord.equals("attack")) {
            if (secondWord.equals(null)) {
                System.out.println("Attack what?");
            } else if (secondWord.compareTo("troll") == 0 && currentRoom.getEnemytype().compareTo("troll") == 0) {
                //Battle Troll
            	dead=trollBattle();
            } else if (secondWord.toUpperCase().equals("BARBARIAN KING") && currentRoom.getEnemytype().toUpperCase().equals("BARBARIAN KING")) {
                //Battle King
            } else {
                System.out.println("There are no " + secondWord + "s here!!!");
            }

        } else if (commandWord.equals("quit")) {
            if (command.hasSecondWord())
                System.out.println("Quit what?");
            else
                return true;
        } else if (commandWord.equals("unlock door")) {
            //Unlock mechanism

        } else if (commandWord.equals("eat")) {
            System.out.println("Do you really think you should be eating at a time like this?");
        } else if ((commandWord.equals("east") || commandWord.equals("north") || commandWord.equals("south") ||
                commandWord.equals("west") || commandWord.equals("up") || commandWord.equals("down"))) {
        	
        	if (commandWord.equals("east")&&(currentRoom.nextRoom("east")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("east");
        		if(currentRoom.isLocked()&&!HasKey(player.getPlayerInv(), currentRoom.getKeyname())){
        			currentRoom=oldroom;
        			System.out.println("That door is locked!!!");
        		}
        	}else if (commandWord.equals("north")&&(currentRoom.nextRoom("north")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("north");
        		if(currentRoom.isLocked()&&!HasKey(player.getPlayerInv(),currentRoom.getKeyname())){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
        	}else if (commandWord.equals("west")&&(currentRoom.nextRoom("west")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("west");
        		if(currentRoom.isLocked()&&!HasKey(player.getPlayerInv(), currentRoom.getKeyname())){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
        	}else if (commandWord.equals("south")&&(currentRoom.nextRoom("south")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("south");
        		if(currentRoom.isLocked()&&!HasKey(player.getPlayerInv(), currentRoom.getKeyname())){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
        	}else if (commandWord.equals("up")&&(currentRoom.nextRoom("up")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("up");
        		if(currentRoom.isLocked()&&!HasKey(player.getPlayerInv(), currentRoom.getKeyname())){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
        	}else if (commandWord.equals("down")&&(currentRoom.nextRoom("down")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("down");
        		if(currentRoom.isLocked()&&!HasKey(player.getPlayerInv(), currentRoom.getKeyname())){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
           	}else{
        		System.out.println("There is nothing in this direction!!!");
        	}
        }
		return false;
    }

    // implementations of user commands:

    private boolean HasKey(Inventory playerInv, String string) {
    	if(playerInv!=null)
		return playerInv.contains(string);
		return false;
	}

	/**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    
    private void printHelp() {
        System.out.println("You are trapped in a apartment complex.  Your goal is to reach the roof and escape");
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println("This game was created by Justin Borromeo and Shon Czinner.");
    }
    
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null)
            System.out.println("There is no door!");
        else {
            currentRoom = nextRoom;
            System.out.println();
            System.out.println(currentRoom.longDescription());
        }
    }
    public boolean trollBattle() throws InterruptedException {
        Troll troll = new Troll(20, 100, 50, 3);
        int playerhealth = player.getPlayerhealth();
        int playerspeed = 50;
        int playeraccuracy = player.getACCURACY();
        int enemyhealth = troll.getTrollhealth();
        int enemyspeed = troll.getTrollspeed();
        int enemyaccuracy = troll.getTrollaccuracy();
        int enemyattack = troll.getTrollattack();

        if (playerspeed > enemyspeed) {
            playerAttack(playeraccuracy, enemyhealth);
        }
        while (playerhealth > 0 && enemyhealth > 0) {
            if (playerhealth > 0 && enemyhealth > 0) {
                int originalenemyhealth = enemyhealth;
                enemyhealth = playerAttack(playeraccuracy, enemyhealth);
                if (enemyhealth < originalenemyhealth) {
                    System.out.println("Your attack was successful and you have dealt " + 10 + " damage.  The troll now has " + enemyhealth + " health.");
                } else {
                    System.out.println("Your attack was unsuccessful and you did not deal any damage.  The troll now has " + enemyhealth + " health.");
                }
                Thread.sleep(1000);
            }
            if (playerhealth > 0 && enemyhealth > 0) {
                int originalplayerhealth = playerhealth;
                playerhealth = trollAttack(enemyaccuracy, playerhealth);
                if (playerhealth < originalplayerhealth) {
                    System.out.println("The troll's attack was successful and has dealt you " + 4 + " damage.  You now have " + playerhealth + " health.");
                } else {
                    System.out.println("The troll's attack was unsuccessful and did not deal any damage.  You now have " + playerhealth + " health.");
                }
            } Thread.sleep(1000);
        }

        player.setPlayerhealth(playerhealth);

        if (player.getPlayerhealth() <= 0) {
            System.out.println("You have died.  Game Over.");
            return true;
        } else {
            System.out.println("You have defeated the troll.  You now have " + playerhealth + " health");
        }
        Thread.sleep(1000);
        return false;
    }

    private boolean trollAttackSuccessful(int enemyaccuracy) {
        int randomized = (int)(Math.random() * 100);
        if (randomized >= enemyaccuracy) {
            return false;
        } else {
            return true;
        }
    }

    private boolean playerAttackSuccessful(int playeraccuracy) {
        int randomized = (int)(Math.random() * 100);
        if (randomized >= playeraccuracy) {
            return false;
        } else {
            return true;
        }
    }

    private int playerAttack(int playeraccuracy, int enemyhealth) {
        boolean success = playerAttackSuccessful(playeraccuracy);
        if (success) {
            enemyhealth -= 10;
        }

        return enemyhealth;
    }

    private int trollAttack(int enemyaccuracy, int playerhealth) {
        boolean success = trollAttackSuccessful(enemyaccuracy);
        if (success) {
            playerhealth -= 10;
        }

        return playerhealth;
    }



}