package de.idealo.toyrobot.robot;

import de.idealo.toyrobot.tabletop.Tabletop;

/**
 * Class for the ToyRobot
 * 
 * @author Fabian Friehe
 *
 */
public class Robot {	
	
	private int posX = -1;
	private int posY = -1;
	
	private Direction direction;

	private Tabletop tabletop;
	
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Direction getDirection() {
		return direction;
	}
	
	public void setTabletop(Tabletop tabletop) {
		this.tabletop = tabletop;
	}
	
}
