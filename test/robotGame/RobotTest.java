package robotGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import robotGame.Heading.HeadingVal;

public class RobotTest
{
	Robot rob = new Robot();
	
	@Test
	public void gettingStarted()
	{		
		rob.processInstruction("");
		assertTrue(!rob.started());
		rob.processInstruction("  move");
		assertTrue(!rob.started());
		rob.processInstruction("  report");
		assertTrue(!rob.started());
		rob.processInstruction("  place");
		assertTrue(!rob.started());
		rob.processInstruction("left  ");
		assertTrue(!rob.started());
		rob.processInstruction("  right ");
		assertTrue(!rob.started());
		rob.processInstruction("  PLACE 1,2 ");
		assertTrue(!rob.started());
		rob.processInstruction("  PLACE 1, North ");
		assertTrue(!rob.started());
		rob.processInstruction("  PLACE 1,2 east");
		assertTrue(!rob.started());
		rob.processInstruction("  PLACE ,2 west");
		assertTrue(!rob.started());
		rob.processInstruction("  PLACE 1,2 blah");
		assertTrue(!rob.started());
		rob.processInstruction("  PLACE 1,2, North");
		assertTrue(rob.started());
	}
	@Test
	public void testPlacing()
	{
		rob.processInstruction("  PLACE 1,2, North");
		assertTrue(rob.started());

		rob.processInstruction("  PLACE 1,2 ");
		assertResult(1,2,HeadingVal.NORTH);
		rob.processInstruction("  PLACE 1, North ");
		assertResult(1,2,HeadingVal.NORTH);
		rob.processInstruction("  PLACE 1,2 east");
		assertResult(1,2,HeadingVal.NORTH);
		rob.processInstruction("  PLACE ,2 west");
		assertResult(1,2,HeadingVal.NORTH);
		rob.processInstruction("  PLACE 1,2 blah");
		assertResult(1,2,HeadingVal.NORTH);
		rob.processInstruction("  PLACE 1,  0, EAST");
		assertResult(1,0,HeadingVal.EAST);
	}
	@Test
	public void testMovement()
	{
		rob.processInstruction("  PLACE 0, 0, North");
		assertTrue(rob.started());

		int i = 0;
		int newVal = 0;
		int y = -1;
		int x = 0;
		for (; y != newVal; i++)
		{
			y =  newVal;
			rob.processInstruction(" move");
			if (y <= 3)
			{
				assertResult(x, y + 1, HeadingVal.NORTH);
			}
			newVal = rob.getMyPlace().getyAxis();
		}
		assertTrue(i == 5);
		rob.processInstruction("  right");
		i = 0;
		newVal = 0;
		y = 4;
		x = -1;
		for (; x != newVal; i++)
		{
			x =  newVal;
			rob.processInstruction(" move");
			if (x <= 3)
			{
				assertResult(x + 1, y, HeadingVal.EAST);
			}
			newVal = rob.getMyPlace().getxAxis();
		}
		assertTrue(i == 5);
		
//		rob.processInstruction(" move");
//		assertResult(1,3,HeadingVal.NORTH);
//		rob.processInstruction(" move");
//		assertResult(1,4,HeadingVal.NORTH);
//		rob.processInstruction(" move");
//		assertResult(1,4,HeadingVal.NORTH);
//		rob.processInstruction("  left");
//		assertResult(1,4,HeadingVal.WEST);
//		rob.processInstruction(" move");
//		assertResult(0,4,HeadingVal.WEST);
//		rob.processInstruction(" move");
//		assertResult(0,4,HeadingVal.WEST);
//		rob.processInstruction("  left");
//		assertResult(0,4,HeadingVal.WEST);
		
	}
	private void assertResult(int x, int y, HeadingVal heading)
	{
		assertTrue(rob.getMyPlace().getxAxis() == x
				&& rob.getMyPlace().getyAxis() == y
				&& rob.getMyHeading().getHeading() == heading);
	}

}
