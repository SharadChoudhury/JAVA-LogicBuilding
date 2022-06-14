package Strings;

public class ReverseEachWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="etonf gut";
		int i,j;
		String rev="";
		int start=0;
		
		for(i=0;i<str.length();i++) {
			
			if(str.charAt(i)==' ') {
             String s=""; // each time a space is found, use a new string to hold the 
           // reversed word till previous index instead of adding every char one by 
           // one to rev , this becomes cumbersome when rev becomes very large.
                
// adding a word to huge string is easier than adding a char one by one to
     //the huge string
				j=i-1;
				while(j>=start) {
					s+=str.charAt(j);
					j--;
				}
				start=i+1;
				rev=rev+s+" ";
			}	
			
		}
		
		for(int k=i-1;k>=start;k--)
			rev+=str.charAt(k);
        
		
//		String ans="";
//        int currentWordStart=0;
//        int i=0;
//        for(;i<str.length();i++){
//            if(str.charAt(i)==' '){
//                //Reverse Current Word
//                int currentWordEnd=i-1;
//                String reversedWord="";
//                for(int j=currentWordStart;j<=currentWordEnd;j++){
//                    reversedWord=str.charAt(j)+reversedWord;
//                }
//                //Add it final String(ans)
//                ans+=reversedWord+" ";
//                currentWordStart=i+1;
//            }
//        }
//        int currentWordEnd=i-1;
//        String reversedWord="";
//        for(int j=currentWordStart;j<=currentWordEnd;j++){
//            reversedWord=str.charAt(j)+reversedWord;
//        }
//        ans+=reversedWord;
//        return ans;
	
		System.out.println(rev);
		
	}

}
