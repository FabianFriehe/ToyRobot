package de.idealo.toyrobot.controller;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.idealo.toyrobot.Controller;

public class ControllerTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Controller controller;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		controller = new Controller();
	}

	@Test
	public void simulateRobotTest() {
		controller.simulateRobot("commands.txt");
		assertEquals("Output: 0, 1, NORTH\n", outContent.toString());
	}
	
	@Test
	public void simulateRobotTest2() {
		controller.simulateRobot("commands2.txt");
		assertEquals("Output: 0, 0, WEST\n", outContent.toString());
	}
	
	@Test
	public void simulateRobotTest3() {
		controller.simulateRobot("commands3.txt");
		assertEquals("Output: 3, 3, NORTH\n", outContent.toString());
	}
	
	@Test
	public void simulateRobotTest4() {
		controller.simulateRobot("commands4.txt");
		assertEquals("Output: ROBOT MISSING\n", outContent.toString());
	}
	
	@Test
	public void simulateRobotTest5() {
		controller.simulateRobot("commands5.txt");
		assertEquals("Output: 1, 1, SOUTH\n", outContent.toString());
	}
	
	@Test
	public void simulateRobotTest6() {
		controller.simulateRobot("commands6.txt");
		assertEquals("Incorrect input!\nOutput: 1, 1, SOUTH\n", outContent.toString());
	}
			

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

}
