package de.idealo.toyrobot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import de.idealo.toyrobot.input.Reader;
import de.idealo.toyrobot.robot.Direction;
import de.idealo.toyrobot.robot.Robot;
import de.idealo.toyrobot.tabletop.SquareTabletop;
import de.idealo.toyrobot.tabletop.Tabletop;

/**
 * Controller Class to simulate the robot
 * 
 * @author Fabian Friehe
 *
 */
public class Controller {

	/**
	 * Creates the robot, initialize and close the reader and starts the
	 * commandLoop
	 * 
	 */
	public void simulateRobot(String filename) {
		Robot robot = createRobot();
		Reader reader = null;
		try {
			// call with no parameter for console input
			reader = new Reader(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found. Start console input.");
			reader = new Reader();
		} catch (NoSuchElementException e) {
			System.out.println("File without EXIT command");
			e.printStackTrace();
		}
		commandLoop(robot, reader);
		reader.endInput();

	}

	/**
	 * Creates the robot
	 * 
	 * @return the robot
	 */
	private static Robot createRobot() {
		Tabletop tabletop = new SquareTabletop(5);
		return new Robot(tabletop);
	}

	/**
	 * Starts the commandLoop
	 */
	private static void commandLoop(Robot robot, Reader reader) {
		boolean loop = true;
		while (loop) {
			String command = reader.readInput();
			loop = callRobotFunction(robot, command);
		}
	}

	/**
	 * Calls the robot functions depending on the command
	 * 
	 * @param robot
	 * @param loop
	 * @param command
	 * @return false if command is EXIT
	 */
	private static boolean callRobotFunction(Robot robot, String command) {
		// Regex for PLACE command
		String placeCommandRegex = "PLACE\\s\\d+,\\d+,(NORTH|WEST|SOUTH|EAST)";
		boolean commandMatchesPlaceCommandRegex = Pattern.matches(placeCommandRegex, command);
		if (commandMatchesPlaceCommandRegex) {
			String[] splitResults = command.split("\\s")[1].split(",");
			int posX = Integer.parseInt(splitResults[0]);
			int posY = Integer.parseInt(splitResults[1]);
			Direction direction = Direction.valueOf(splitResults[2]);

			robot.place(posX, posY, direction);
		} else if ("MOVE".equals(command)) {
			robot.move();

		} else if ("RIGHT".equals(command)) {
			robot.right();

		} else if ("LEFT".equals(command)) {
			robot.left();

		} else if ("REPORT".equals(command)) {
			System.out.print(robot.toString() + "\n");

		} else if ("EXIT".equals(command)) {
			return false;
		} else {
			System.out.print("Incorrect input!\n");
		}
		return true;
	}
}
