/**
 * Dynamic Programming Problem to solve the pretty text problem and optimize the messiness
 *
 * @author Varun Joshi
 *
 */
import java.util.*;

public class PrettyText {

	public static int optimizeMesiness(List<String> words, int lineSize) {
		// Stores the messiness after each word essentially
		int messines[] = new int[words.size()];
		
		//Fill Values in the messines Array
		for(int i = 0; i < messines.length; i++) {
			messines[i] = Integer.MAX_VALUE;
		}
		
		int remainingBlanks = lineSize - words.get(0).length();
		messines[0] = remainingBlanks * remainingBlanks;
		
		for(int i = 1; i < words.size(); i++) {
			remainingBlanks = lineSize - words.get(i).length();
			messines[i] = messines[i-1] + remainingBlanks*remainingBlanks;

			
			//Adding more Words + Optimization 
			for(int j = i - 1; j >= 0; j--) {
				// Extra 1 added to accomodate for the one space between blanks
				remainingBlanks -= (words.get(j).length() + 1);
				
				// Entering Invalid Case
				if(remainingBlanks < 0) {
					break;
				}
				   
				int beforeMessiness = 0;
				
				if(j - 1 >= 0) {
					beforeMessiness = messines[j - 1];
				} 
				
				int currentMessiness = remainingBlanks * remainingBlanks;
				
				messines[i] = Math.min(messines[i], beforeMessiness + currentMessiness);
				
			}
		}
		
		return messines[words.size() - 1];
	}
	
	// Driver Code to Test the Program
	public static void main(String[] args) {
		List<String> xyz = new ArrayList<>();
		/*xyz.add("I");
		xyz.add("have");
		xyz.add("inserted");
		xyz.add("a");
		xyz.add("large");
		xyz.add("number");
		xyz.add("of");
		xyz.add("new");
		xyz.add("examples");
		xyz.add("from");
		xyz.add("the");
		xyz.add("papers");
		xyz.add("for");		
		xyz.add("the");
		xyz.add("Mathematical");
		xyz.add("Tripos");
		xyz.add("during");
		xyz.add("the");
		xyz.add("last");
		xyz.add("twenty");
		xyz.add("years,");
		xyz.add("which");
		xyz.add("should");
		xyz.add("be");
		xyz.add("useful");
		xyz.add("to");
		xyz.add("Cambridge");
		xyz.add("students.");*/
		
		xyz.add("text");
		xyz.add("tes");
		
		System.out.println(optimizeMesiness(xyz, 8));
	}
}

/*
 * I have inserted a large number,
of new examples from the papers
for the Mathematical Tripos during
the last twenty years, which should 
be useful to Cambridge students
 */
