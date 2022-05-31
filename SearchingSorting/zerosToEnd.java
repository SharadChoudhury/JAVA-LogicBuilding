package SearchingSorting;

public class zerosToEnd {

	public static void main(String[] args) {
		
//time complexity= O(n)
//space complexity= O(1)
		
		int[] arr= {0,2,0,0,7,8};		
		int n = arr.length;
        int k = 0; 
        for (int i = 0; i < n; i++)
            if (arr[i] > 0) {
            	arr[k] = arr[i];
            	k++;
            }
                 
        
        while (k < n)
            arr[k++] = 0;
        
        for(int ele:arr)
        	System.out.print(ele+" ");
        
	}

}
