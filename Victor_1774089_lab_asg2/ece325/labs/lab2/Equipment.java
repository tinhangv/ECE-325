package ece325.labs.lab2;

/** 
 * Finish this class.
 */
public class Equipment {
	//field to store the type of equipment
	protected String type;
	
	//override the toSTring method to print the type of equipment
	//the method is inherited by all subclasses of equipment
	@Override
	public String toString() {
		return type;
	}
}
