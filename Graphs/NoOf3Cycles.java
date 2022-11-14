package Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoOf3Cycles {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int solve(boolean[][] graph, int n) {
		//Implement this
		
		//Time: O(n^3)				space: O(n^2)
		int count = 0;
        
        for(int i=0; i<n; i++){
        	
            for(int j=0; j<n; j++){
            	
            	//if edge exists between i and j, and j is different from i
                if(j!=i && graph[i][j] == true){
                	
                    for(int k=0; k<n; k++){
                    	
                    	//if edge exists b/w j and k, and k is different from i and j
                        if(k!=i && k!=j && graph[j][k] == true){ 
                        	
                        	//and if edge exists b/w 'k' and 'i' means it's a triangle, so increase count
                            if(graph[k][i] == true)  
                                count++;
                        }
                    }
                }
            }
        }
        
        //since every triangle is counted 6 times, so divide by 6 to get total triangles
        //we are not marking the vertex in a triangle as visited here, as two different triangles might
        //share a common vertex, so if we mark it visited then we will lose the count of the other triangles
        return count/6;
	}

	public static boolean[][] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int m = Integer.parseInt(strNums[1]);

		boolean[][] graphs = new boolean[n][n];
		int firstvertex, secondvertex;

		for (int i = 0; i < m; i++) {
			String[] strNums1;
			strNums1 = br.readLine().split("\\s");
			firstvertex = Integer.parseInt(strNums1[0]);
			secondvertex = Integer.parseInt(strNums1[1]);
			graphs[firstvertex][secondvertex] = true;
			graphs[secondvertex][firstvertex] = true;
		}
		return graphs;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[][] graphs = takeInput();

		int ans = solve(graphs, graphs.length);
		System.out.println(ans);

	}
}