package robotGame;

import java.util.*;
import java.io.*;

public class MyClass
{
	Map<String, Map<String, Integer>> sortMap = new HashMap<String, Map<String, Integer>>();

	public MyClass(String name, int num)
	{

	}
	public void Swap() throws IOException
	{
		FileReader f = new FileReader("\\var\\local\\settings.xml");
		BufferedReader rbuf = new BufferedReader(f);

		String line;
		while ((line = rbuf.readLine()) != null)
		{
			System.out.println();
		}
	}
}