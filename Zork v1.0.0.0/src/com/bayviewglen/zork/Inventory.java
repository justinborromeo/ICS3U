package com.bayviewglen.zork;

import java.io.Serializable;
import java.util.HashMap;

public class Inventory implements Serializable{
private HashMap<String, Item> inventory = new HashMap<String, Item>();

 //An Inventory object is a hashmap of items in a room or belonging to the player
 
	Inventory(){
		this.inventory = new HashMap<String, Item>();
	 }
	 
	 public void addItem(Item item){
		 inventory.put(item.getName().toUpperCase(), item);
	 }
	 
	 public void removeItem(Item item){
		 inventory.remove(item.getName().toUpperCase());
	 }
	 
	 boolean contains(String itemname){
		 return inventory.containsKey(itemname.toUpperCase());
	 }
	 
	 Item getItem(String itemname){
		Item item=inventory.get(itemname.toUpperCase());
		return item;
		 
	 }
	
	public void print() {
		for (String name: inventory.keySet()){
	
	        System.out.println("Item: " + name);  
	
		} 
	}
	 
 
}
