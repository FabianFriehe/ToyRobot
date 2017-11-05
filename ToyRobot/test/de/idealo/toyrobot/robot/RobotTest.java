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
		placeRobot(0, 0);
		placeRobot(4, 4);
	}
	
	@Test
	public void placeTest2() {
		placeRobotFalse(-1, 0);
		placeRobotFalse(4, -1);
		placeRobotFalse(-1, -1);
		placeRobotFalse(5, 4);
		placeRobotFalse(0, 5);
		placeRobotFalse(5, 5);
	}

	private void placeRobotFalse(int posX, int posY) {
		boolean placeSucces = robot.place(posX, posY);
		
		int posXRobot = robot.getPosX();
		int posYRobot = robot.getPosY();
		
		assertEquals(-1, posXRobot);
		assertEquals(-1, posYRobot);
		assertFalse(placeSucces);
	}
	
	private void placeRobot(int posX, int posY) {
		boolean placeSucces = robot.place(posX, posY);
		
		int posXRobot = robot.getPosX();
		int posYRobot = robot.getPosY();
		
		assertEquals(posX, posXRobot);
		assertEquals(posY, posYRobot);
		assertTrue(placeSucces);
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
