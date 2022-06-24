package Recursion;
import java.util.*;
public class returnAllCodesFromString {// bottom to top approach for returning
	
	public static  String[] getCode(String input) {
		
		if(input.length()==0)
			return new String[]{""};
		
		String[] arr1= getCode(input.substring(1));
		for(int i=0;i<arr1.length;i++) {
			arr1[i] = (char)(96 + input.charAt(0)-'0') + arr1[i];
		}
		
		if(input.length()>=2 && Integer.parseInt(input.substring(0,2)) >= 10
				&& Integer.parseInt(input.substring(0,2)) <= 26) {
			
			String arr2[]= getCode(input.substring(2));
			for(int i=0;i<arr2.length;i++) {
				arr2[i]=(char)(96 + Integer.parseInt(input.substring(0,2))) + arr2[i];
			}
			
			String arr3[]= new String[arr1.length + arr2.length];
			int i;
			for(i=0;i<arr1.length;i++) {
				arr3[i]= arr1[i];
			}
			for(int j=0;j<arr2.length;j++) {
				arr3[i]=arr2[j];
				i++;
			}
			
			return arr3;
		}
		else
			return arr1;
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String output[] = getCode(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
