package de.idealo.toyrobot.tabletop;


/**
 * Abstract Class for Tabletop with square(x^2) format
 * 
 * @author Fabian Friehe
 *
 */
public class SquareTabletop extends Tabletop {
	
	int sideLength;
	
	
	public SquareTabletop(int sideLength) {
		super();
		if (sideLength <= 0) {
			throw new IllegalArgumentException( "No side Length <= 0 allowed!" );
		}
		this.sideLength = sideLength;
		fields = new boolean[sideLength][sideLength];
	}


	@Override
	public boolean canMove(int posX, int poxY) {
		boolean posXBetween0andSideLength = posX >= sideLength || posX < 0;
		boolean posYBetween0andSideLength = poxY >= sideLength || poxY < 0;
		if(posXBetween0andSideLength || posYBetween0andSideLength) {
			return false;
		}
		return true;
	}
	
	
	

}
