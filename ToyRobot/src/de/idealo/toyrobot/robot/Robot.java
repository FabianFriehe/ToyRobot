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

	/**
	 * Move the robot one unit forward in the direction it is currently facing.
	 * 
	 * @return false if the robot can not move forward
	 */
	public boolean move() {
		if (direction == null) {
			return false;
		}

		int newPosX = this.posX;
		int newPosY = this.posY;

		switch (this.direction) {
		case NORTH:
			newPosY++;
			break;
		case WEST:
			newPosX--;
			break;
		case SOUTH:
			newPosY--;
			break;
		case EAST:
			newPosX++;
			break;
		}

		boolean canMoveToNewPosition = tabletop.canMove(newPosX, newPosY);
		if (!canMoveToNewPosition) {
			return false;
		}

		this.posX = newPosX;
		this.posY = newPosY;

		return true;
	}

	/**
	 * Rotate the robot 90 degrees left. If the robot is not placed the function
	 * returns null.
	 * 
	 * @return direction after the rotation. null if the robot is not placed.
	 */
	public Direction left() {
		if (this.direction == null) {
			return null;
		}

		switch (this.direction) {
		case NORTH:
			this.direction = Direction.WEST;
			break;
		case WEST:
			this.direction = Direction.SOUTH;
			break;
		case SOUTH:
			this.direction = Direction.EAST;
			break;
		case EAST:
			this.direction = Direction.NORTH;
			break;
		}

		return this.direction;
	}

	/**
	 * rotate the robot 90 degrees right. If the robot is not placed the
	 * function returns null.
	 * 
	 * @return direction after the rotation. null if the robot is not placed.
	 */
	public Direction right() {
		if (this.direction == null) {
			return null;
		}

		switch (this.direction) {
		case NORTH:
			this.direction = Direction.EAST;
			break;
		case WEST:
			this.direction = Direction.NORTH;
			break;
		case SOUTH:
			this.direction = Direction.WEST;
			break;
		case EAST:
			this.direction = Direction.SOUTH;
			break;
		}

		return this.direction;
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
