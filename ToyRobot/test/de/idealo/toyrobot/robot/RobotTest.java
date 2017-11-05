package de.idealo.toyrobot.robot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.idealo.toyrobot.tabletop.SquareTabletop;

public class RobotTest {
	
	private Robot robot;

	@Before
	public void before() {
		SquareTabletop squareTabletop = new SquareTabletop(5);
		robot = new Robot(squareTabletop);
	}
	
	@Test
	public void placeTest() {
		placeRobot(0, 0, Direction.NORTH);
		placeRobot(4, 4, Direction.WEST);
	}
	
	@Test
	public void placeTest2() {
		placeRobotFalse(-1, 0, Direction.NORTH);
		placeRobotFalse(4, -1, Direction.WEST);
		placeRobotFalse(-1, -1, Direction.EAST);
		placeRobotFalse(5, 4, Direction.SOUTH);
		placeRobotFalse(0, 5, Direction.NORTH);
		placeRobotFalse(5, 5, Direction.WEST);
		placeRobotFalse(-2, 8, null);
		placeRobotFalse(2, 3, null);
	}

	private void placeRobotFalse(int posX, int posY, Direction direction) {
		boolean placeSucces = robot.place(posX, posY, direction);
		
		int posXRobot = robot.getPosX();
		int posYRobot = robot.getPosY();
		
		assertEquals(-1, posXRobot);
		assertEquals(-1, posYRobot);
		assertFalse(placeSucces);
		assertNull(robot.getDirection());

	}
	
	private void placeRobot(int posX, int posY, Direction direction) {
		boolean placeSucces = robot.place(posX, posY, direction);
		
		int posXRobot = robot.getPosX();
		int posYRobot = robot.getPosY();
		
		assertEquals(posX, posXRobot);
		assertEquals(posY, posYRobot);
		assertTrue(placeSucces);
		assertEquals(direction, robot.getDirection());
	}

	@Test
	public void initTest() {
		SquareTabletop squareTabletop = new SquareTabletop(5);
		Robot robotTest = new Robot(squareTabletop);
		
		assertEquals(-1, robotTest.getPosX());
		assertEquals(-1, robotTest.getPosY());
		assertEquals(null, robotTest.getDirection());

	}

}
