package robotGame;

public class Robot
{
	private Location myPlace = new Location();

	private Heading myHeading = new Heading();

	public enum command
	{
		PLACE, MOVE, LEFT, RIGHT, REPORT;
	}

	public void processInstruction(String doit)
	{
		String inst = doit.trim();
		int idx = inst.indexOf(' ');
		if (idx > 0)
		{
			inst = inst.substring(0, idx);
		}

		if (inst.length() > 0)
		{
			if (inst.trim().equalsIgnoreCase(command.PLACE.toString()) && idx > 0)
			{
				String params = doit.trim().substring(idx);
				if (params != null && params.length() > 0)
				{
					String[] paramVals = params.split(",");
					if (paramVals.length > 0 && paramVals.length >= 3)
					{
						myPlace.setLocation(paramVals[0].trim(), paramVals[1].trim());
						if (myPlace.started())
						{
							myHeading.setInitial(paramVals[2].trim());
						}
						if (!myHeading.started())
						{
							myPlace.reset();
						}
					}
				}
			} else if (inst.trim().equalsIgnoreCase(command.MOVE.toString()))
			{
				getMoving();
			} else if (inst.trim().equalsIgnoreCase(command.LEFT.toString()))
			{
				myHeading.turnLeft();
				;
			} else if (inst.trim().equalsIgnoreCase(command.RIGHT.toString()))
			{
				myHeading.turnRight();
			} else if (inst.trim().equalsIgnoreCase(command.REPORT.toString()))
			{
				if (started())
				{
					StringBuffer outp = new StringBuffer("Output: ");
					outp.append(myPlace.getxAxis());
					outp.append(",");
					outp.append(myPlace.getyAxis());
					outp.append(",");
					outp.append(myHeading.toString());
					System.out.println(outp.toString());
				}
			}
		}
	}

	private void getMoving()
	{
		if (started())
		{
			switch (myHeading.getHeading())
			{
			case NORTH:
				myPlace.moveY(1);
				break;
			case EAST:
				myPlace.moveX(1);
				break;
			case SOUTH:
				myPlace.moveY(-1);
				break;
			case WEST:
				myPlace.moveX(-1);
				break;
			default:
				System.out.println("Internal Server Error");
			}
		}
	}

	boolean started()
	{
		return myPlace.started() && myHeading.started();
	}

	Location getMyPlace()
	{
		return myPlace;
	}

	Heading getMyHeading()
	{
		return myHeading;
	}
	
}
