package Arrays;
import java.util.*;

public class Arrange
{
    public static void arrange(int[] arr, int n) {
    	//time complexity= O(n)
    	//space complexity= O(1)
        for(int i=1,j=0,k=n-1 ; i<=n ; i++){
            if(i%2==1){
                arr[j]=i;
                j++;
            }
            else{
                arr[k]=i;
                k--;
            }
        }
        for(int i=0;i<n;i++){
           System.out.print(arr[i]+" "); 
        }
        
    }

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
          int n = s.nextInt();
          int arr[] = new int[n];
          arrange(arr,n);
          t--;
        }
    }
  
}
