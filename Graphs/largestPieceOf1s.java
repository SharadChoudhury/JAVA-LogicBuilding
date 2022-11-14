package Graphs;

public class largestPieceOf1s {

	static int size = 0;  //keep it global so that it can be updated whenever required and anywhere
	
	public static int dfs(String[] edge, int n) {
        //time : O(n^2)			space: O(n^2)
		
        int[][] grid = new int[n][n];
		for(int i=0 ;i<n ; i++){
            for(int j=0; j<n ; j++){
                grid[i][j] = edge[i].charAt(j) - '0';
            }
        }
        
        int max = 0;  //to keep track of max cake size of 1's
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                size = 0;
                if(grid[i][j] == 1){  //visited 1s won't be taken as they are already marked as -1
                    int smallres = findsize(grid, n, i, j);
                    if(smallres > max)
                        max = smallres;
                }
            }
        }
        
        return max;       
	}

    
    public static int findsize(int[][] grid, int n, int i, int j){
        
    	if(i<0 || i>=n || j<0 || j>=n)
            return size;
        
        if(grid[i][j] == 1){
            size++; 			//increment size whenever 1 is found in continuation            
            grid[i][j] = -1;   //mark as visited, and don't make it unvisited again because we take all the 
            // connected 1's in a single traversal, so we don't want to count them again
            
            int res1 = findsize(grid,n,i,j-1);
            int res2 = findsize(grid,n,i,j+1);
            int res3 = findsize(grid,n,i-1,j);
            int res4 = findsize(grid,n,i+1,j);
            
            return Math.max(res1,Math.max(res2,Math.max(res3,res4)));  //return the max size of 1s found
        }
        
      //if 1 is not found here, size will stay the same as it was till the previous call
        return size;  
    }
	
}
