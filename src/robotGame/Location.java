package robotGame;

public class Location
{
	static final int BOARDLOWLIMIT = 0;
	static final int BOARDHIGHLIMIT = 4;
	
	private int xAxis = -1;
	private int yAxis = -1;
	
	public int getxAxis()
	{
		return xAxis;
	}

	public int getyAxis()
	{
		return yAxis;
	}
	public boolean started()
	{
		return xAxis >= BOARDLOWLIMIT;
	} 
	public void reset()
	{
		xAxis = -1; yAxis = -1;
	}
	public boolean validXlocation(int x)
	{
		return x >= BOARDLOWLIMIT && x <= BOARDHIGHLIMIT;
	}
	public boolean validYlocation(int y)
	{
		return y >= BOARDLOWLIMIT && y <= BOARDHIGHLIMIT;
	}
	public void setLocation(String xVal, String yVal)
	{
		try
		{
			int xInt = Integer.parseInt(xVal);
			int yInt = Integer.parseInt(yVal);
			setLocation(xInt, yInt);
		}
		catch (Exception e)
		{
			// don't care - do nothing
		}
	}
	public void setLocation(int x, int y)
	{
		if (validXlocation(x) &&  validYlocation(y))
		{
			xAxis = x;
			yAxis = y;
		}
	}
	public void moveX(int squares)
	{
		if (started() && validXlocation(xAxis + squares))
		{
			xAxis += squares;
		}
	}
	public void moveY(int squares)
	{
		if (started() && validYlocation(yAxis + squares))
		{
			yAxis += squares;
		}
	}
}
