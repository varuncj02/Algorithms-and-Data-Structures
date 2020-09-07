import java.util.*;

/**
 * Program to optimize the path of the triangle that it takes
 *  
 * @author Varun Joshi
 *
 *Type of Problem: Dynamic Programming 
 */
public class TriangePath {
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.isEmpty()) {
			return 0;
		}
		
		// Idea is to select the minimum value in the next row based on what indexes it touches in the prev row
		// totalSum += min(currRow[i-1], currRow[i+1])
		
		/*
		 * Common Pitfall with the above equation is that the algorithm could end up being implemented as a 
		 * greedy algorithm. So we need to keep rechecking to make sure that this path is shorter than all the 
		 * other alternatives.
		 * 
		 */
		
		List<Integer> prevRow = new ArrayList<>(triangle.get(0));
		
		//Traversing through all the rows
		for(int i = 1; i < triangle.size(); i++) {
			List<Integer> currRow = new ArrayList<>(triangle.get(i));
			currRow.set(0, currRow.get(0) + prevRow.get(0));
			
			//To make sure that all the options are thoroughly tested
			for(int j = 1; j < currRow.size() - 1; j++) {
				currRow.set(j, currRow.get(j) + Math.min(prevRow.get(j), prevRow.get(j-1)));
				
			}
			
			currRow.set(currRow.size()-1, currRow.get(currRow.size()-1)+ prevRow.get(prevRow.size()- 1));
			prevRow = currRow;
		}
		
		// Return the MinimumValue of all
		return Collections.min(prevRow);
		
	}
	
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		List<Integer> x = new ArrayList<Integer>();
		x.add(2);
		
		List<Integer> y = new ArrayList<Integer>();
		y.add(2);
		y.add(3);
		
		List<Integer> z = new ArrayList<Integer>();
		z.add(6);
		z.add(4);
		z.add(1);
		
		triangle.add(x);		
		triangle.add(y);
		triangle.add(z);

		System.out.println(minimumTotal(triangle));
		
		
	}
	

}
