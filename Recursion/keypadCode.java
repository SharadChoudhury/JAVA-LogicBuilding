package Recursion;
import java.util.*;
public class keypadCode {
    
	public static String[] keypad(int n){
	//time: O(4^n) ; n = no.of digits in input n
	//space: O(4^n)
		if(n<10){
            return helper(n);
        }
		
        String[] small1= keypad(n/10);
        String[] small2= helper(n%10);
        
        String[] out=new String[small1.length*small2.length];
        
        int i,j,k=0;
        for(i=0;i<small1.length;i++) {
        	for(j=0;j<small2.length;j++) {
        		out[k]=small1[i]+small2[j];
        		k++;
        	}
        }        
        return out;
	}
    
	
    public static String[] helper(int n){
        switch(n) {
        case 2:
        	return new String[]{"a","b","c"};
        case 3:
        	return new String[]{"d","e","f"};
        case 4:
        	return new String[]{"g","h","i"};
        case 5:
        	return new String[]{"j","k","l"};
        case 6:
        	return new String[]{"m","n","o"};
        case 7:
        	return new String[]{"p","q","r","s"};
        case 8:
        	return new String[]{"t","u","v"};
        case 9:
        	return new String[]{"w","x","y","z"};
        default:
        	return new String[] {""};
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		String output[] = keypad(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
