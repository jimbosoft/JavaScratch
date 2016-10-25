package robotGame;

import static org.junit.Assert.*;

import org.junit.Test;

import robotGame.Heading.HeadingVal;

public class HeadingTest
{
	@Test
	public void testStarted()
	{
		Heading h = new Heading();
		assertTrue(!h.started());
		h.turnLeft();
		assertTrue(!h.started());
		h.turnRight();
		assertTrue(!h.started());
		h.setInitial("WhoCares");
		assertTrue(!h.started());
		h.setInitial("  north  ");
		assertTrue(h.started());
		h = new Heading();
		h.setInitial("EAST");
		assertTrue(h.started());
		h = new Heading();
		h.setInitial("  South");
		assertTrue(h.started());
		h = new Heading();
		h.setInitial("wesT  ");
		assertTrue(h.started());
	}

	@Test
	public void testTurnLeft()
	{
		Heading h = new Heading();
		assertTrue(!h.started());
		h.turnLeft();
		assertTrue(!h.started());
		h.setInitial("north");
		assertTrue(h.started());
		h.turnLeft();
		assertTrue(h.toString().equals(HeadingVal.WEST.toString()));
		h.turnLeft();
		assertTrue(h.toString().equals(HeadingVal.SOUTH.toString()));
		h.turnLeft();
		assertTrue(h.toString().equals(HeadingVal.EAST.toString()));
		h.turnLeft();
		assertTrue(h.toString().equals(HeadingVal.NORTH.toString()));	
	}

	@Test
	public void testTurnRight()
	{
		Heading h = new Heading();
		assertTrue(!h.started());
		h.turnRight();
		assertTrue(!h.started());
		h.setInitial("north");
		assertTrue(h.started());
		h.turnRight();
		assertTrue(h.toString().equals(HeadingVal.EAST.toString()));
		h.turnRight();
		assertTrue(h.toString().equals(HeadingVal.SOUTH.toString()));
		h.turnRight();
		assertTrue(h.toString().equals(HeadingVal.WEST.toString()));
		h.turnRight();
		assertTrue(h.toString().equals(HeadingVal.NORTH.toString()));	
	}

}
