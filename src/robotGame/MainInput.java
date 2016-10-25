package robotGame;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import onlineTest.SolutionIter;

public class MainInput
{
	static List<String> cluster = new ArrayList<String>();
	static List<List<String>> clusterList = new ArrayList<List<String>>();
	
	public static void main(String[] args)
	{
		StringReader strReader = new StringReader("  10 34 - 11 \n 42");
		FileReader fileReader = null;
		try
		{
			fileReader = new FileReader("inp.txt");
			
			for (Integer x : new SolutionIter(fileReader)) 
			{
				 System.out.println(x);
			}

		} catch (FileNotFoundException e)
		{
			System.out.println("File not found exception " + e.getMessage());
		}
		finally
		{
			if (strReader != null)
			{
				strReader.close();
			}
			if (fileReader != null)
			{
				try
				{
					fileReader.close();
				} catch (IOException e)
				{
					System.out.println("Closing file reader exception " + e.getMessage());
				}
			}
		}
	}	
	public  static int solution(int[] inList) 
	{
		//List<Integer> inp = IntStream.of(inList).boxed().collect(Collectors.toList());
	//	IntStream stream1 = Arrays.stream(inList);
		
		int inSize = inList.length;
		
		for (int i = 1; i < inSize - 1; i++)
		{
			long leftSum = Arrays.stream(inList).limit(i).asLongStream().sum();
			long rightSum = Arrays.stream(inList).skip(i).asLongStream().sum();
		/*	List<Integer> left = inp.subList(0, i);
			List<Integer> right = inp.subList(i + 1, inSize);
			
			Long leftSum = left.stream().collect(Collectors.summingLong(Integer::intValue));
			Long rightSum = right.stream().collect(Collectors.summingLong(Integer::intValue));
			
			if (leftSum.equals(rightSum))
			{
				return i;
			}*/
			if(leftSum == rightSum)
				return i;
		}
		
		return -1;
	}
	
	public static void mySolution()
	{
		try
		{
			//BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			//System.out.println("I got: " + stdin.readLine().trim());
			
			int[] test1 = {-1,-4,5, -1};
			
			
			System.out.println("Got: " + solution(test1, 1));
			System.out.println("Got: " + solution(test1, 2));
			System.out.println("Got: " + solution(test1, 3));
			
		}
		catch (Exception ex)
		{
			System.out.println("Something went wrong ..." + ex.getMessage());
		}
	}
	public  static int solution(int[] inpList, int attempts) 
	{
		List<Integer> intList = IntStream.of(inpList).boxed().collect(Collectors.toList());
		
		int nr = 0;
		int listSize = intList.size();
		for (int i = 0; i < listSize; i++)
		{
			List<Integer> first, second = new ArrayList<Integer>();
			int leftTotal = 0;
			int rightTotal = 0;
			
			first = intList.subList(0, i);

			if (i < listSize)
			{
				second = intList.subList(i + 1, listSize);
			}
			leftTotal = first.stream().collect(Collectors.summingInt(Integer::intValue));
			rightTotal = second.stream().collect(Collectors.summingInt(Integer::intValue));
			
			if (leftTotal == rightTotal)
			{
				nr++;
				if (nr == attempts)
				{
					return i;
				}
			}
		}
		
        return -1;
    }
	public static void Atest()
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		try
		{
			double threshhold = getDouble(stdin.readLine().trim());
			int nrItems = -1;
			if (threshhold >= 0)
			{
				nrItems = getNumberOfRelations(stdin.readLine().trim());
			}
			if (threshhold >= 0 && nrItems > 0)
			{			
				for (int i = 0; i < nrItems; i++)
				{
					processItemAff(stdin.readLine().trim(), threshhold);
				}
				processClusterList();
			}
		} catch (IOException e)
		{
			System.out.println("Program shut down due to IOError: " + e.getMessage());
		}
	}

	public static double getDouble(String params)
	{
		double val = -1;
		try
		{
			val = Double.parseDouble(params.trim());
		}
		catch(Exception ex)
		{
			return -1;
		}
		return val;
	}
	public static int getNumberOfRelations(String in)
	{
		int nr = -1;
		try
		{
			nr = Integer.parseInt(in.trim());
		}
		catch(Exception ex)
		{
			return -1;
		}
		return nr;
	}
	public static void processItemAff(String line, double threshhold)
	{
		String[] paramVals = line.split(" ");
		
		if (paramVals.length != 3)
		{
			System.out.println("Error in item affinity tiple");
		}
		 double prob = getDouble(paramVals[2]);
		 
		 if (prob > threshhold)
		 {
			 if (cluster.size() > 0)
			 {
				 if (cluster.get(cluster.size() - 1).equals(paramVals[0]))
				 {
					 cluster.add(paramVals[2]);
				 }
				 else
				 {
					 clusterList.add(cluster);
					 cluster = new ArrayList<String>();
				 }
			 }
			 if (cluster.size() == 0)
			 {
				 cluster.add(paramVals[0]);
				 cluster.add(paramVals[1]);
				 
			 }
		 }
	}
	static private void processClusterList()
	{
		int largestCluster = 0;
		List<List<String>> largestClusterList = new ArrayList<List<String>>();

		for(int i = 0; i < clusterList.size(); i++)
		{
			if (clusterList.get(i).size() > largestCluster)
			{
				largestCluster = clusterList.get(i).size();
			}
		}
		for (int i = 0; i < clusterList.size(); i++)
		{
			if (clusterList.get(i).size() == largestCluster)
			{
				largestClusterList.add(clusterList.get(i));
			}
		}
		int idxBiggest = 0;
		for (int i = 0; i < largestClusterList.size(); i++)
		{
			String last = "";
			for (int x = 0; x < largestClusterList.get(i).size(); x++)
			{
				if (last.length() == 0 || largestClusterList.get(i).get(x).compareTo(last) < 0)
				{
					last = largestClusterList.get(i).get(x);
					idxBiggest = i;
				}				
			}
		}
		System.out.println(largestClusterList.get(idxBiggest).get(0));
		
	}
//	while ((line = stdin.readLine()) != null && line.length() != 0)
//	{
//		System.out.println(processInput(line));
//		//rob.processInstruction(line);
//	}
//		String result = "Not jolly";
//		
//		String[] paramVals = params.split(" ");
//		
//		int x;
//		int prev = 0;
//		int numCount = 0;
//		Map<Integer, Integer> diffs = new HashMap<Integer, Integer>();
//		
//		for (String num : paramVals)
//		{	
//			if ( num.length() > 0)
//			{
//				try
//				{
//					x = Integer.parseInt(num.trim());
//				}
//				catch(Exception ex)
//				{
//					return result;
//				}
//				if ( x >= 3000)
//				{
//					return result;
//				}
//				if (numCount > 0)
//				{
//					int diff = Math.abs(prev - x);
//					
//					if (diffs.containsValue(diff))
//					{
//						return result;
//					}
//					diffs.put(diff, diff);		
//				}
//				numCount++;;
//				prev = x;
//			}
//		}
//		for (int i = 1; i < numCount; i++)
//		{
//			if (!diffs.containsValue(i))
//			{
//				return result;
//			}
//		}
//		return "Jolly";
//	}
	
}
