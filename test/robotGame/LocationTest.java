package robotGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest
{
	@Test
	public void testSetLocation()
	{
		Location loc = new Location();
		assertTrue(!loc.started());
		
		loc.setLocation(-3, -5);
		assertTrue(!loc.started());
		
		loc.setLocation(1,5);
		assertTrue(!loc.started());

		loc.setLocation(5, 0);
		assertTrue(!loc.started());
		
		loc.setLocation(5, 5);
		assertTrue(!loc.started());
		
		loc.setLocation(0, 0);
		assertTrue(loc.started());
	}

	@Test
	public void testMoveX()
	{
		Location loc = new Location();
		loc.setLocation(1, 5);
		loc.moveX(1);
		assertTrue(!loc.started());
		loc.setLocation(0, 0);
		loc.moveX(-1);
		assertTrue(loc.getxAxis() == 0 && loc.getyAxis() == 0);
		loc.moveX(1);
		assertTrue(loc.getxAxis() == 1 && loc.getyAxis() == 0);
		loc.setLocation(4, 4);
		loc.moveX(1);
		assertTrue(loc.getxAxis() == 4 && loc.getyAxis() == 4);
	}

	@Test
	public void testMoveY()
	{
		Location loc = new Location();
		loc.setLocation(1, 5);
		loc.moveY(1);
		assertTrue(!loc.started());
		loc.setLocation(0, 0);
		loc.moveY(-1);
		assertTrue(loc.getxAxis() == 0 && loc.getyAxis() == 0);
		loc.moveY(1);
		assertTrue(loc.getxAxis() == 0 && loc.getyAxis() == 1);
		loc.setLocation(4, 4);
		loc.moveY(1);
		assertTrue(loc.getxAxis() == 4 && loc.getyAxis() == 4);
	}

}
