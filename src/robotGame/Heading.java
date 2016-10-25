package robotGame;

public class Heading
{
	public enum HeadingVal
	{
		NORTH, EAST, SOUTH, WEST;
		private static HeadingVal[] vals = values();
		public HeadingVal next()
		{
			return vals[(this.ordinal() + 1) % vals.length];
		}
		public HeadingVal previous()
		{
			int idx = this.ordinal() - 1 % vals.length;
			if (idx < 0)
			{
				idx += vals.length;
			}
			return vals[idx];
		}
	}

	private HeadingVal heading;

	public HeadingVal getHeading()
	{
		return heading;
	}

	public boolean started()
	{
		return heading != null;
	}

	public String toString()
	{
		return heading.toString();
	}

	public void setInitial(String newHeading)
	{
		if (newHeading.trim().equalsIgnoreCase(HeadingVal.NORTH.toString()))
		{
			heading = HeadingVal.NORTH;
		} else if (newHeading.trim().equalsIgnoreCase(HeadingVal.EAST.toString()))
		{
			heading = HeadingVal.EAST;
		} else if (newHeading.trim().equalsIgnoreCase(HeadingVal.SOUTH.toString()))
		{
			heading = HeadingVal.SOUTH;
		} else if (newHeading.trim().equalsIgnoreCase(HeadingVal.WEST.toString()))
		{
			heading = HeadingVal.WEST;
		}
	}

	public void turnLeft()
	{
		if (started())
		{
			heading = heading.previous();
		}
	}

	public void turnRight()
	{
		if (started())
		{
			heading = heading.next();
		}
	}
}
