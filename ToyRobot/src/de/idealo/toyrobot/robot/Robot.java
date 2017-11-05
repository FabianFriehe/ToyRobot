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

	public Robot(Tabletop tabletop) {
		super();
		this.tabletop = tabletop;
	}

	/**
	 * Place the robot on the tabletop
	 * 
	 * @param posX
	 *            x coordinate
	 * 
	 * @param poxY
	 *            y coordinate
	 * @param direction
	 *            direction
	 * @return true if the robot if placed successfully
	 */
	public boolean place(int posX, int posY, Direction direction) {
		boolean isInvalidPlaceParameter = !tabletop.canMove(posX, posY) || direction == null;
		if (isInvalidPlaceParameter) {
			return false;
		}
		this.posX = posX;
		this.posY = posY;
		this.direction = direction;
		return true;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Direction getDirection() {
		return direction;
	}

}
