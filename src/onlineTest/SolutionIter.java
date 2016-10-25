package onlineTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SolutionIter implements Iterable<Integer>
{
	List<Integer> fileContent = new ArrayList<Integer>();
	
	public SolutionIter(Reader inp)
	{	
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(inp);
			String line = br.readLine();
			
			while (line != null)
			{
				boolean numberFound = false;
				StringBuffer number = new StringBuffer();
				for (int i = 0; i < line.length() && !numberFound; i++)
				{
					char c = line.charAt(i);
					if (c == ' ')
					{
						if (number.length() > 0)
						{
							numberFound = true;
						}
						else
						{
							continue;
						}
					}
					else if (Character.isDigit(c))
					{
						number.append(c);
					}
					else
					{
						number.delete(0, number.length());
						break;
					}
				}
				try
				{
					if (number.length() > 0)
					{
						Integer res = Integer.parseInt(number.toString());
						fileContent.add(res);
					}
				}
				catch (Exception ex)
				{
					System.out.println("Int converstion failed for " 
							+ number + " exception " + ex.getMessage());
				}
				line = br.readLine();
			}
		}catch (Exception ex)			
		{
			System.out.println("SolutionIter exception " + ex.getMessage());
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				} catch (IOException e)
				{
					System.out.println("Closing buffered reader failed " + e.getMessage());
				}
			}
		}
	}

	public Iterator<Integer> iterator()
	{
		return fileContent.iterator();
	}
}
