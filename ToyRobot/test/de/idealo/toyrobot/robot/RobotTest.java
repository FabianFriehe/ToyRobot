package de.idealo.toyrobot.robot;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void initTest() {
		Robot robotTest = new Robot();
		
		assertEquals(-1, robotTest.getPosX());
		assertEquals(-1, robotTest.getPosY());
		assertEquals(null, robotTest.getDirection());

	}

}
