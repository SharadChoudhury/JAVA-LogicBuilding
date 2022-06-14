package Strings;

public class reverseStringWordwise {
	
	public static String reverseWordWise(String input) {

	//shortcut-method 
		
        // String[] arr= input.split(" ");
        // String rev=arr[0];
        // for(int i=1;i<arr.length;i++)
        //     rev = arr[i] + " " + rev;
        
        String rev = "";
        for(int i=input.length()-1;i>=0;i--){
            
            if(input.charAt(i)==' '){
                int j=i+1;
                while( j<input.length() && input.charAt(j)!=' ' ){
                    rev += input.charAt(j);
                    j++;
                }
                rev+=" ";
            }
            
        }
        
        int i=0;
        while(input.charAt(i)!=' '){
            rev+=input.charAt(i);
            i++;
        }
        
      
		return rev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "the sky is blue"; 
		System.out.println(reverseWordWise(str));
	}
	
}
