import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * 
 * @author Varun Joshi
 *
 */
public class topologicalSort {
	
	private int vertices;
	
	private ArrayList<ArrayList<Integer>> adjacencyList;
	
	//Stack<Integer> stack;
	
	topologicalSort(int vertices){
		this.vertices = vertices;
		
		adjacencyList = new ArrayList<ArrayList<Integer>>(vertices);          
		for (int i = 0; i < vertices; ++i)  {
            adjacencyList.add(new ArrayList<Integer>());  
        }
		
		//stack = new Stack<Integer>();
		
	}
	
	//Building AdjacencyList for DAG
	void addEdge(int v1, int v2) {
		adjacencyList.get(v1).add(v2);
	}
	
	ArrayList<Integer> sort() {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		 boolean isVisited[] = new boolean[vertices];  
	        for (int i = 0; i < vertices; i++)  {
	            isVisited[i] = false;  
	        }
	        
	        for(int i = 0; i < vertices; i++) {
	        	if(!isVisited[i]) {
	        		dfs(stack, isVisited, i);
	        	}
	        }
	        
	        while(!(stack.isEmpty())) {
	        	result.add(stack.pop());
	        }
	        
	        return result;
	}
	
	
	// Recursive function
	void dfs(Stack<Integer> stack, boolean[] isVisited, int curV ) {
		isVisited[curV] = true;
		
		//Traversal through individual ArrayList of certain Vertex in adjacency List
		/*int temp = 0;                                                          
		for(int i = 0; i < adjacencyList.get(curV).size() - 1; i++) {
			temp = adjacencyList.get(curV).get(i + 1);
			System.out.println("Temp printed " + temp);
			if(!isVisited[i]) {
				dfs(stack, isVisited, temp);
			}
		}*/
		
		Integer i;
        Iterator <Integer> iterator = adjacencyList.get(curV).iterator();
        while(iterator.hasNext())
        {
            i = iterator.next();
            System.out.println("Iterator print " + i);
            if(isVisited[i] == false)
                dfs(stack, isVisited, i);
        }
		
		stack.push(curV);
	}
	
	 public static void main(String args[])  
	    {  
	        // Create a graph given in the above diagram  
	        topologicalSort dag = new topologicalSort(6);  
	        //dag.addEdge(1, 3);  
	       // dag.addEdge(1, 3);  
	        //dag.addEdge(2, 4);  
	       // dag.addEdge(3, 0);  
	           
	        //dag.addEdge(3, 1);  
	        dag.addEdge(0, 5);  
	        dag.addEdge(0, 4);  
	        dag.addEdge(5, 4);  
	        dag.addEdge(1, 4);  
	        dag.addEdge(1, 2);  
	        dag.addEdge(2, 3);  
	    
	        System.out.println("Topological Sort of graph is " + dag.sort());  
	        //dag.sort();  
	    } 

}
