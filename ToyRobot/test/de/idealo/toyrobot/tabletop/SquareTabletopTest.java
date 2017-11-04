package de.idealo.toyrobot.tabletop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class SquareTabletopTest {

	private SquareTabletop squareTabletop;

	@Before
	public void before() {
		squareTabletop = new SquareTabletop(5);
	}

	@Test
	public void initTest() {
		createFields(5);
		createFields(1);
	}

	@Test(expected = Exception.class)
	public void initFalseTest1() {
		createFields(0);
	}

	@Test(expected = Exception.class)
	public void initFalseTest2() {
		createFields(-1);
	}

	private void createFields(int sideLength) {
		SquareTabletop squareTabletopTest = new SquareTabletop(sideLength);

		boolean[][] testFields = squareTabletopTest.getFields();

		int lengthX = testFields.length;

		assertEquals(sideLength, lengthX);

		for (int i = 0; i < lengthX; i++) {
			int lengthY = testFields[i].length;
			assertEquals(sideLength, lengthY);
		}
	}

	@Test
	public void canMoveTest() {
		assertEquals(true, squareTabletop.canMove(0, 0));
		assertEquals(true, squareTabletop.canMove(4, 4));
		assertEquals(true, squareTabletop.canMove(3, 1));

		assertEquals(false, squareTabletop.canMove(0, 5));
		assertEquals(false, squareTabletop.canMove(5, 4));
		assertEquals(false, squareTabletop.canMove(5, 5));
		assertEquals(false, squareTabletop.canMove(-1, 3));
		assertEquals(false, squareTabletop.canMove(2, -1));


	}

}
