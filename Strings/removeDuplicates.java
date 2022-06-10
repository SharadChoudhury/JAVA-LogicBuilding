package Strings;

public class removeDuplicates {
// remove consecutive duplicate characters
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

// method 1: 
//create a frequency array of all characters.If char_freq>0 ,append to result string  
		
//method 2: scan array once and append to result string only once 
		String str = "aaabbbca";
		String res = "";
        for(int i=0;i<str.length();){
            res+=str.charAt(i);
            int j=i+1;
            while(j<str.length() && str.charAt(j)==str.charAt(i)){
                j++;
                i++;
            }
            i=j;               
        }   
        System.out.println(res);
	}

}
