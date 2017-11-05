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

	/**
	 * Returns if the Robot can be moved to the field with the coordinates
	 * 
	 * @param posX x coordinate
	 * @param posY y coordinate
	 * @return if the Robot can be moved to the field with the coordinates
	 */
	public abstract boolean canMove(int posX, int posY);

	public boolean[][] getFields() {
		return fields;
	}

}
