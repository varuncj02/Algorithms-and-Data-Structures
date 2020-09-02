import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;

// Using the HashSet approach to solve the problem 
public class DuplicateRows {
	Set<String> set = new HashSet<String>();
	
	public List<Integer> duplicates(int[][] matrix) {
		if(matrix.length == 0 || matrix == null) {
			return null;
		}
		
		List<Integer> duplicates = new ArrayList<>();
		
		for(int i = 0; i < matrix.length; i++) {
			String s = "";
			for(int j = 0; j < matrix[0].length; j++) {
				s += (matrix[i][j]);
			}
			if(set.contains(s)) {
				duplicates.add(i+1);
			}
			else {
				set.add(s);
			}
		}
		
		return duplicates;
	}
	
	public static void main(String[] args) {
		DuplicateRows duplicateRows = new DuplicateRows();
		int[][] matrixes = {
				{ 1,0,0,1,0},
				{ 0,1,1,0,0},
				{ 1,0,0,1,0},
				{ 0,0,1,1,0},
				{ 0,1,1,0,0},
		};
		System.out.println(duplicateRows.duplicates(matrixes));
	}
	
}



