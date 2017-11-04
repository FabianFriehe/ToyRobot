package de.idealo.toyrobot.tabletop;

/**
 * Abstract Class for Tabletop
 * 
 * @author Fabian Friehe
 *
 */
public abstract class Tabletop {
	
	/**
	 * Field is true if a robot is on it
	 */
	boolean[][] fields;
		
	
	public boolean[][] getFields() {
		return fields;
	}

}
