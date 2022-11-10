package DP_2;

public class minCostPath2D {
	//we can only move one step at a time to the right or bottom or diagonally down.
	
	//Recursion
	//Time: O(3^(m*n))					Space: max stack space = height of tree = max path length in grid = O(m+n)
	public static int minCostPath(int[][] input) {
        return minCostPath(input,0,0);
	}
	
    public static int minCostPath(int[][] input, int i ,int j){
        if(i >= input.length || j >= input[0].length) //if we go beyond the matrix length, then there is no way to reach 
        	//destination from there. So return maximum cost possible.
            return Integer.MAX_VALUE;
        
        if(i == input.length-1 && j == input[0].length-1) //if you are already at the destination, minimum cost to reach 
			//destination from here is the cost of this cell, so return it 
            return input[i][j];
        
        //options of paths we can take from this cell:
        int x = minCostPath(input, i+1, j); 	//move one step down
        int y = minCostPath(input, i, j+1); 	//move one step right
        int z = minCostPath(input, i+1, j+1);	//move one step diagonally down
        
        return input[i][j] + Math.min(x,Math.min(y,z));   //add the current cell cost to minimum cost obtained from all paths
        //taken from this cell
    }
	
    
    //	Memoization
    //  Source: (0,0) --> top    Destination: (m-1,n-1) --> Bottom		  (top-down approach)
    //	Time: O(m*n)				space: O(m*n)  {ignoring the stack space} 
    public static int minCostPathM(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int storage[][] = new int[m][n];
		for(int i = 0; i < m ; i++){
			for(int j = 0; j < n; j++){
				storage[i][j] = -1;
			}
		}
		return minCostPathM(arr, 0, 0, storage);
	}

	private static int minCostPathM(int[][] arr, int i, int j, int[][] storage) {
		int m = arr.length;
		int n = arr[0].length;

		if(i >= m || j >= n){
			return Integer.MAX_VALUE;
		}

		if(i == m - 1 && j == n - 1){     //if you are at the destination, minimum cost to reach destination from here
			//is the cost of this cell, so return it
			storage[i][j] = arr[i][j];
			return storage[i][j];
		}

		if(storage[i][j] != -1){
			return storage[i][j];
		}

		int op1 = minCostPathM(arr, i , j + 1, storage);   		//move one step right
		int op2 = minCostPathM(arr, i + 1, j + 1, storage);		//move one step diagonally down
		int op3 = minCostPathM(arr, i + 1, j, storage );		//move one step down 
		
		//add the current cell value to the minimum cost obtained from all paths taken from this cell
		storage[i][j] = arr[i][j] + Math.min(op1,  Math.min(op2, op3));
		return storage[i][j];
	}
		
	
	//	DP approach
	// 	here, source = (m-1,n-1) (Bottom)        destination: (0,0) (up)  --> Bottom up approach
	//	Time: O(m*n)				space: O(m*n)
	public  static int minCostPathDP(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		
		//at each cell of this array, we store the minimum cost from this cell to the destination
		int storage[][] = new int[m][n];   
		
		//minimum cost to reach destination from destination is the value at destination cell
		storage[m - 1][n - 1] = arr[m - 1][n - 1];  
		
		// At Last Row
		for(int j = n - 2; j >= 0; j--)
			storage[m - 1][j] = storage[m - 1][j + 1] + arr[m - 1][j];   //minimum cost is the cost from its right cell to the
			//destination + cost of this cell
		
		// At Last Column
		for(int i = m - 2; i >= 0; i--)
			storage[i][n - 1] = storage[i + 1][n - 1] + arr[i][n - 1];  //minimum cost is the cost from its bottom cell to the
			//destination + cost of this cell
				
		for(int i = m - 2; i >= 0; i--){
			for(int j = n - 2; j >= 0; j--){
				storage[i][j] = arr[i][j] +  Math.min(storage[i][j + 1], 
						Math.min(storage[i + 1][j + 1], storage[i + 1][j]));
			}
		}
		return storage[0][0];
	}
	

	//Main function
	public static void main(String args[]){
		int arr[][] = {{1,1,1}, {4,5,2},{7,8,9}};
		System.out.println(minCostPathDP(arr));
		System.out.println(minCostPathM(arr));
		System.out.println(minCostPath(arr));
	}
}
