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
	
	@Test
	public void initTest() {
		SquareTabletop squareTabletop = new SquareTabletop(5);
		Robot robotTest = new Robot(squareTabletop);
		
		assertEquals(-1, robotTest.getPosX());
		assertEquals(-1, robotTest.getPosY());
		assertEquals(null, robotTest.getDirection());

	}
	
	@Test
	public void moveTest() {
		moveNorth(0, 0);
		moveNorth(3, 3);
		
		moveSouth(4, 4);
		moveSouth(1, 1);
		
		moveWest(4, 4);
		moveWest(1, 1);
		
		moveEast(0, 0);
		moveEast(3, 3);
	}
	
	@Test
	public void moveTest2() {
		moveNorthFalse(0, 4);
		moveNorthFalse(4, 4);
		
		moveSouthFalse(0, 0);
		moveSouthFalse(4, 0);
		
		moveWestFalse(0, 0);
		moveWestFalse(0, 4);
		
		moveEastFalse(4, 4);
		moveEastFalse(4, 0);
	}
	
	@Test
	public void moveTest3() {
		assertFalse(robot.move());
		assertEquals(-1, robot.getPosX());
		assertEquals(-1, robot.getPosY());
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

	private void moveNorth(int posX, int posY) {
		robot.place(posX, posY, Direction.NORTH);
		assertTrue(robot.move());
		
		assertEquals(posX, robot.getPosX());
		assertEquals(posY + 1, robot.getPosY());
	}
	
	private void moveNorthFalse(int posX, int posY) {
		robot.place(posX, posY, Direction.NORTH);
		assertFalse(robot.move());
		
		assertEquals(posX, robot.getPosX());
		assertEquals(posY, robot.getPosY());
	}
	
	private void moveSouth(int posX, int posY) {
		robot.place(posX, posY, Direction.SOUTH);
		assertTrue(robot.move());
		
		assertEquals(posX, robot.getPosX());
		assertEquals(posY - 1, robot.getPosY());
	}
	
	private void moveSouthFalse(int posX, int posY) {
		robot.place(posX, posY, Direction.SOUTH);
		assertFalse(robot.move());
		
		assertEquals(posX, robot.getPosX());
		assertEquals(posY, robot.getPosY());
	}
	
	private void moveWest(int posX, int posY) {
		robot.place(posX, posY, Direction.WEST);
		assertTrue(robot.move());
		
		assertEquals(posX - 1, robot.getPosX());
		assertEquals(posY, robot.getPosY());
	}
	
	private void moveWestFalse(int posX, int posY) {
		robot.place(posX, posY, Direction.WEST);
		assertFalse(robot.move());
		
		assertEquals(posX, robot.getPosX());
		assertEquals(posY, robot.getPosY());
	}
	
	private void moveEast(int posX, int posY) {
		robot.place(posX, posY, Direction.EAST);
		assertTrue(robot.move());
		
		assertEquals(posX + 1, robot.getPosX());
		assertEquals(posY, robot.getPosY());
	}
	
	private void moveEastFalse(int posX, int posY) {
		robot.place(posX, posY, Direction.EAST);
		assertFalse(robot.move());
		
		assertEquals(posX, robot.getPosX());
		assertEquals(posY, robot.getPosY());
	}


}
