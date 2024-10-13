package ece325.labs.lab2;

import java.util.ArrayList;
import java.util.HashMap;

/** 
 * Finish this class.
 */
public class EquipmentInventory {

	/** The list of all your equipment objects */
	ArrayList<Equipment> inventory;
	/** The number of objects per type of equipment, grouped by the String description of a type */
	HashMap<String, Integer> inventoryCount;

	/** 
	 * Create an EquipmentInventory object by initializing the inventory and inventoryCount objects.
	 */
	public EquipmentInventory() {
		inventory = new ArrayList<Equipment>();
		inventoryCount = new HashMap<String, Integer>();
	}

	/**
	 * Add e to the inventory, and if the add is successful, increase the number of that equipment type in your inventoryCount.
	 * Make sure that you cannot accidentally add the same object twice.
	 * @param e The equipment object to add
	 */
	public void add(Equipment e) {
		//if the equipment is not already contained in inventory, add it to the inventory array and increase its count
		if (!inventory.contains(e)) {
			inventory.add(e);
			increaseInventoryCount(e);
		}
	}

	/**
	 * Remove e from the inventory and if successful, decrease the number of that equipment type in your inventoryCount.
	 * @param e The equipment object to remove
	 */
	public void remove(Equipment e) {
		//if the equipment is in inventory, remove it from the inventory array and decrease its count
		if(inventory.contains(e)) {
			inventory.remove(e);
			decreaseInventoryCount(e);
		}
	}

	/**
	 * Increase the inventoryCount for the type of equipment of e by 1.
	 * If it does not exist in the inventoryCount yet, add the type to the inventoryCount.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to increase the inventoryCount
	 */
	protected void increaseInventoryCount(Equipment e) {
		//increase the count of the equipment by 1 in the inventoryCount hashmap using its string representation as index
		if(inventoryCount.containsKey(e.toString())) {
			inventoryCount.put(e.toString(), inventoryCount.get(e.toString())+1);
		}else {
			//add the equipment type to the hashmap if it doesn't already exist
			inventoryCount.put(e.toString(), 1);
		}
	}

	/**
	 * Decrease the inventoryCount for the type of equipment of e by 1.
	 * If the inventoryCount for this type is now 0, remove the type from the inventoryCount.
	 * If the inventoryCount does not contain this type of equipment, do nothing.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to decrease the inventoryCount
	 */
	protected void decreaseInventoryCount(Equipment e) {
		//decrease the count of the equipment by 1 in the inventory count hashmap using its string representation as index
		if(inventoryCount.containsKey(e.toString())) {
			inventoryCount.put(e.toString(), inventoryCount.get(e.toString())-1);
		}
		//remove the type from inventoryCount if amount is 0
		if(inventoryCount.get(e.toString()) == 0) {
			inventoryCount.remove(e.toString());
		}
	}

	/** 
	 * Return the number of times this type of equipment occurs in the inventory.
	 * If it doesn't occur in the inventory, return -1 (to indicate that something went wrong somewhere).
	 * @param e
	 * @return
	 */
	public Integer getInventoryCount(Equipment e) {
		//return the equipment count if it's not 0, and -1 if none exists in inventory
		return inventoryCount.getOrDefault(e.toString(), -1);
	}
	
	/**
	 * Return the String representation of the EquipmentInventory.
	 * It should look similarly to the following:
	 * [EquipmentInventory: Guitar: 3, Stool: 3, Chair: 1, Keyboard: 2]
	 * (after adding 3 guitars, 3 stools, 1 chair and 2 keyboards).
	 * The order in which the types are printed does not matter.
	 * @return the string representation of the EquipmentInventory
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[EquipmentInventory: ");
		inventoryCount.forEach((type, num) -> {
			//append type name to string, make plural if more than 1
			String typeStr = (num >1)? type + "s" : type;
			//append the amount
			s.append(typeStr + ": " + num.toString() + ", ");
		});
		
		//correct the formating
		if(!inventoryCount.isEmpty()) {
			s.delete(s.length()-2, s.length());
		}
		s.append("]");
		
		return(s.toString());
	}

	public static void main(String[] args) {
		EquipmentInventory inv = new EquipmentInventory();
		//add 3 guitars, 2 keyboards, 3 stools, 1 chair
		Chair chair = new Chair();
		Stool s1 = new Stool();
		Stool s2 = new Stool();
		Stool s3 = new Stool();
		Keyboard k1 = new Keyboard();
		Keyboard k2 = new Keyboard();
		Guitar g1 = new Guitar();
		Guitar g2 = new Guitar();
		Guitar g3 = new Guitar();
		inv.add(chair);
		inv.add(s1);
		inv.add(s2);
		inv.add(s3);
		inv.add(k1);
		inv.add(k2);
		inv.add(g1);
		inv.add(g2);
		inv.add(g3);
		System.out.println(inv);
		//remove a keyboard and a chair
		inv.remove(k1);
		inv.remove(s2);
		System.out.println(inv);
		
	}
}
