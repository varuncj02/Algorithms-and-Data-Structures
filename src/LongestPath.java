/**
 * Cost from Longest Path to Other Paths in the DAG 
 * @author Varun Joshi
 *
 */
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack; 
  
// Class Representing the Graph 
class Graph 
{ 	
    int vertices; 
    ArrayList<Integer> edge[]; 
  
    Graph(int vertices)  
    { 
        this.vertices = vertices; 
        edge = new ArrayList[vertices+1]; 
        for (int i = 0; i <= vertices; i++)  
        { 
            edge[i] = new ArrayList<>(); 
        } 
    } 
    
    void addEdge(int a,int b) 
    { 
        edge[a].add(b); 
    } 
  
    void dfs(int node, ArrayList<Integer> adj[], int dp[], boolean visited[]) 
    { 
        visited[node] = true; 
  
        // Use Dynamic Programming to get the maximum value by storing everything
        for (int i = 0; i < adj[node].size(); i++)  
        { 
  
            if (!visited[adj[node].get(i)]) {
                dfs(adj[node].get(i), adj, dp, visited); 
            }
            dp[node] = Math.max(dp[node ], 1 + dp[adj[node].get(i)]);
            
        } 
    } 
      
    int findLongestPath(int n) 
    { 
        ArrayList<Integer> adj[] = edge; 
        int[] dp = new int[n+1]; 
        
        
        boolean[] isVisited = new boolean[n + 1]; 
  
       
        for (int i = 1; i <= n; i++)  
        { 
            if (!isVisited[i]) 
                dfs(i, adj, dp, isVisited); 
        } 
  
        int ans = 0; 
  
        for (int i = 1; i <= n; i++)  
        { 
            ans = Math.max(ans, dp[i]); 
        } 
        return ans; 
    } 
} 
  
public class LongestPath { 
    public static void main(String[] args) 
    { 
    	// Test Case 1 - Works
        Graph graph = new Graph(5); 
        graph.addEdge( 1, 2); 
        graph.addEdge( 1, 3); 
        graph.addEdge( 3, 2); 
        graph.addEdge( 2, 4); 
        graph.addEdge( 3, 4); 
        graph.findLongestPath(5); 
        System.out.println("Test Case1 " + graph.findLongestPath(5)); 
  
        
        Graph graph2 = new Graph(6);
        graph2.addEdge( 1, 2); 
        graph2.addEdge( 1, 3); 
        graph2.addEdge( 2, 4); 
        graph2.addEdge( 3, 5); 
        graph2.addEdge( 4, 5);
        graph2.addEdge(5, 6);
        graph2.findLongestPath(6);
        System.out.println("Test Case2 " + graph2.findLongestPath(6)); 
    } 
} 
  
