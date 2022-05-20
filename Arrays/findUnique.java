package Arrays;
public class findUnique {

	//time complexity: O(n^2)
	 public static int findUniqueElement(int[] arr){
		//way 1:
		 	// int n=arr.length;
	        // int i;
	        // for(i=0;i<n;i++){
	        //     int flag=0;
	        //     for(int j=0;j<n;j++){
	        //         if( (j!=i) && (arr[i]==arr[j]) ){
	        //             flag=1;
	        //             break;  
	        //         }
	        //     }
	        //     if(flag==0)
	        //         break;
	        // }
	        // return arr[i];
		 
		//way 2: 
	        int n=arr.length;
	        int i,j;
	        
	        for(i=0;i<n;i++){
	            for(j=i+1;j<n && arr[i]!=-1;j++){
	                if(arr[i]==arr[j]){
	                	arr[j]=-1;
	                    break; 
	                }
	            }
	            if(j==n)
	            	return arr[i];  // or return arr[j-1]
	        }
	        
	        return 0;
	    }

// method 2: sort array and check if arr[i]==arr[i+1]:
	 // if true , then i=i+2
	 //else return arr[i]
	 // time complexity = O(nlogn)
	    public static void main (String[] args) {
	        int[] arr = {1,2,3,1,3,4,2};
	        System.out.println(findUniqueElement(arr));
	        
	    }
	  
}
