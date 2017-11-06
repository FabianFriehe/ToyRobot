package de.idealo.toyrobot.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Initialized and close the scanner
 * 
 * @author Fabian Friehe
 *
 */
public class Reader {

	Scanner scanner;

	public Reader() {
		super();
		scanner = new Scanner(System.in);
	}
	
	public Reader(File file) throws FileNotFoundException {
		scanner = new Scanner(file);
	}

	/**
	 * Reads an entered line
	 * 
	 * @return an entered line
	 */
	public String readInput() {
		return scanner.nextLine();
	}

	/**
	 * Should called after all input has entered
	 */
	public void endInput() {
		scanner.close();
	}

}
