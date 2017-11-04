package de.idealo.toyrobot.tabletop;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTabletopTest {

	@Test
	public void initTest() {
		createField(5);
		createField(1);
	}
	
	@Test(expected = Exception.class)
	public void initFalseTest1() {
		createField(0);
	}
	
	@Test(expected = Exception.class)
	public void initFalseTest2() {
		createField(-1);
	}

	private void createField(int sideLength) {
		SquareTabletop squareTabletopTest = new SquareTabletop(sideLength);
				
		boolean[][] testField = squareTabletopTest.getFields();
		
		int lengthX = testField.length;
		
		assertEquals(sideLength, lengthX);
		
		for(int i = 0; i < lengthX; i++) {
			int lengthY = testField[i].length;
			assertEquals(sideLength, lengthY);
		}
	}

}
