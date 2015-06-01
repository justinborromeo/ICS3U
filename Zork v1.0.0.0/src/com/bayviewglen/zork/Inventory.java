package com.bayviewglen.zork;

import java.util.HashMap;

public class Inventory {
 private HashMap<String, Item> inventory = new HashMap<String, Item>();
 
 
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
}
