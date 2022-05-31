package SearchingSorting;

public class CheckArrayRotation {

	public static void main(String[] args) {
		
		// time complexity: O(n)
		// Space complexity: O(1)
		
		int[] arr = {};
        int count=1;
        
        int i=0;
        if(i<arr.length-1){
            
            while(arr[i+1]>arr[i]) {
         	count++;
         	i++;
         	if(i==arr.length-1)
         		break;
         	} 
            
            System.out.println(count);
         }
         else
              System.out.println("0");
       
	}

}
