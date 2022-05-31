package SearchingSorting;

public class RotateArrayLeft {

	public static void main(String[] args) {
		
		int[] arr= {0,2,3,5,7,8};
		int d=8;
		
		int n = arr.length;
		
/* method 1: 
		reverse entire array
		reverse array(0 to n-d-1)
		reverse array(n-d to n-1)
*/
		
//method 2
		// time complexity: O(n)
		// Space complexity: O(n)		
        
     // if d==0 or d==n, no change in array
        if(d>0 && d!=n){   
        	
        	d=d%n;  // in case d is greater than n
        	int[] temp = new int[d];
            int i;
            
           for(i=0;i<d;i++){ // copy d elements to temp
            temp[i]=arr[i];
        	}

            while(i<n){  // shift elements from index= d to index= n-1 by d steps to left
                arr[i-d]=arr[i];
                i++;
            }
            
            i=0;
            while(i<d){
                arr[n-d-i]=temp[i];
                i++;
            } 	          
        }
        
        for(int ele:arr)
        	System.out.print(ele+" "); 
        
	}

}
