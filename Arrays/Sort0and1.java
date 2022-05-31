package Arrays;
// sort the array of zeroes and ones by traversing the array only once 
// don't use nested loops

public class Sort0and1 {
	
	 public static void sortZeroesAndOne(int[] arr) {
	    	
	        int n = arr.length;
	    // method 1     
	        //time: O(n)
	        //space:O(1)
	        int c0=0,i;
	        for(i=0;i<n;i++){
	            if(arr[i]==0)
	                c0++;
	        }
	        
	        for(i=0;i<c0;i++){
	            arr[i]=0;
	        }
	        for(;i<arr.length;i++){
	            arr[i]=1;
	        }
	        
	    // method 2
	        //time: O(n)
	        //space:O(1)
	        int nextzero=0;
	        for(i=0;i<n;i++) {
	        	if(arr[i]==0) {
	        		arr[i]=arr[nextzero];
	        		arr[nextzero]=0;
	        		nextzero++;
	        	}
	        }
	        
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 0, 1, 1 ,0, 1, 0, 1};
		sortZeroesAndOne(arr);
		for(int i:arr){
            System.out.print(i+" ");
        }

	}

}
