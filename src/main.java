import java.util.ArrayList;
import java.util.List;

public class main {
	
	public static void main(String args[]) {
		
		List<String> sample = new ArrayList<String>();
		sample.add("1100");
		sample.add("1110");
		sample.add("0110");
		sample.add("0001");
		/*char[][] test = new char[4][4];
		for(int i = 0; i < test.length; i++) {
			for(int j = 0; j < test[i].length; j++) {
				if( i == 0 && (j == 0 || j == 1)) {
					test[i][j] = 'Y';
				}
				else if( i == 1 && (j == 0 || j == 1 || j == 2)) {
					test[i][j] = 'Y';
				}
				else if( i == 2 && ( j == 1 || j == 2)) {
					test[i][j] = 'Y';
				}
				else if( i == 3 && j == 3) {
					test[i][j] = 'Y';
				}
				else {
					test[i][j] = 'N';
				}
			}
		}*/
		
		int a = getFriendCircles(sample);
		System.out.println(a);
		
	}
	
	public static int getFriendCircles(List<String> friends) {
		if(friends == null || friends.size() < 1) {
			return 0;
		}
		
		char[][] converted = new char[friends.size()][friends.get(0).length()];
		for(int i = 0; i < friends.size(); i++) {
			for(int j = 0; j < friends.get(i).length(); j++) {
				converted[i][j] = friends.get(i).charAt(j);
			}
		}
		
		int circleNumbers = 0;
		
		boolean visited[] = new boolean[friends.size()];
		
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		
		for(int i = 0; i < converted.length; i++) {
			if(!visited[i]) {
				circleNumbers++;
				visited[i] = true;
				findfriends(converted, visited, i);
			}
		}
		
		return circleNumbers;
	}
	
	public static void findfriends(char[][] friends, boolean[] visited, int id) {
		for(int i = 0; i < friends.length; i++) {
			if(!visited[i] && i != id && '1' == friends[id][i]) {
				visited[i] = true;
				findfriends(friends, visited,i);
			}
		}
	}
	
	

}
