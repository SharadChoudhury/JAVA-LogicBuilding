package Strings;

public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "revr"; 
		
		//method 1  O(n/2)
		for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
        
        //method 2  O(n)
//        String rev="";
//        for(int i=0;i<str.length();i++){
//           rev = str.charAt(i) + rev;
//        }
//        if(rev.equals(str))
//        	System.out.println("true");
//        else
//        	System.out.println("false");
// 
        
	}

}
