package com.bayviewglen.zork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    
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
     */
    public void play() 
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
           	Command command=parser.getCommand();
            finished = processCommand(command);
            System.out.println();
            if(!(currentRoom.isBeenhere()))
            	System.out.println(currentRoom.longDescription());
            else
            	System.out.println(currentRoom.getRoomName());
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Hello "+ Player.getName()+ " and welcome to Zork!!!  Zork is an incredibly fun adventure game programmed by Shon and Justin.");
        System.out.println("If you ever need help while playing the game, type in 'help'.  Now, press Enter to continue.");
        String useless=keyboard.nextLine();
        System.out.println();
        if(!(currentRoom.isBeenhere()))
        	System.out.println(currentRoom.longDescription());
        else
        	System.out.println(currentRoom.getRoomName());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command)
    {
        if(command.isUnknown())
        {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        String secondWord=command.getSecondWord();
        if (commandWord.equals("help")){
            printHelp();
        	currentRoom.setBeenhere(true);
        }else if (commandWord.equals("go")){
            goRoom(command);
            currentRoom.setBeenhere(true);
        }else if (commandWord.equals("take")){
        	if(currentRoom.getInventory().contains(secondWord)){
        		Inventory tempinventory=player.getPlayerInv();
        		Inventory currentroominventory=currentRoom.getInventory();
        		Item toTake=currentroominventory.getItem(secondWord);
        		//tempinventory.addItem(toTake);
        		currentroominventory.removeItem(toTake);
        		Player.setPlayerInv(tempinventory);
        		System.out.println("Taken!");
        		currentRoom.setBeenhere(true);
        	}else if (commandWord.equals("drop")){
        	
        	}else{
        		System.out.println("There are no "+secondWord+"s at this location!");
        		currentRoom.setBeenhere(true);
        	}
        }else if (commandWord.equals("inv")){
        	//PrintInventory
        	
        	
        
    	}else if (commandWord.equals("quit")){
            if(command.hasSecondWord())
                System.out.println("Quit what?");
            else
                return true;  // signal that we want to quit
       	}else if(commandWord.equals("unlock door")){
       		//Unlock mechanism
    	
    	}else if (commandWord.equals("eat")){
        	System.out.println("Do you really think you should be eating at a time like this?");
        }else if((commandWord.equals("east")||commandWord.equals("north")||commandWord.equals("south")||
        		commandWord.equals("west")||commandWord.equals("up")||commandWord.equals("down"))){
        	if (commandWord.equals("east")&&(currentRoom.nextRoom("east")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("east");
        		if(currentRoom.isLocked()){
        			currentRoom=oldroom;
        			System.out.println("That door is locked!!!");
        		}
        	}else if (commandWord.equals("north")&&(currentRoom.nextRoom("north")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("north");
        		if(currentRoom.isLocked()){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
        	}else if (commandWord.equals("west")&&(currentRoom.nextRoom("west")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("west");
        		if(currentRoom.isLocked()){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
        	}else if (commandWord.equals("south")&&(currentRoom.nextRoom("south")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("south");
        		if(currentRoom.isLocked()){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
        	}else if (commandWord.equals("up")&&(currentRoom.nextRoom("up")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("up");
        		if(currentRoom.isLocked()){
        			currentRoom=oldroom;
        			System.out.println("That room is locked!!!  You cannot go there!!!");
        		}
        	}else if (commandWord.equals("down")&&(currentRoom.nextRoom("down")!=null)){
        		Room oldroom=currentRoom;
        		currentRoom.setBeenhere(true);
        		currentRoom=currentRoom.nextRoom("down");
        		if(currentRoom.isLocked()){
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

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are trapped in a apartment complex.  Your goal is to reach the roof and escape");
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println("This game was created by Justin Borromeo and Shon Czinner.");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord())
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null)
            System.out.println("There is no door!");
        else 
        {
            currentRoom = nextRoom;
            System.out.println();
          	System.out.println(currentRoom.longDescription());
         }
    }
  
}