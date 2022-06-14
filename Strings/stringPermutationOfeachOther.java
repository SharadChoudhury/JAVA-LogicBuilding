package Strings;

public class stringPermutationOfeachOther {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//two strings are permutations of each other only when the frequency of each character
// is equal in both strings.
		
// if str1="abba" and str2="bbba" then the approach where we check if each char of str1
// is present in str2 will fail and vice versa. So we need to use frequency arrays
	// to keep track of frequency of each char in both arrays.
		
	// method 1: sort both strings lexicographically and compare if they are equal.
	// this is very time consuming and not optimized.
		
	//method2 - using frequency arrays
		int[] freq= new int[255];
		String str1 ="aabb";
		String str2 = "abbb";
        int n1=str1.length();
        int n2=str2.length();
       
        if(n1==n2) {
        	for(char ch:str1.toCharArray()) {
        		freq[ch]+=1;
        	}
        	for(char ch:str2.toCharArray()) {
        		freq[ch]-=1;
        	}
        	
        	for(int i=0;i<255;i++) {
        		if(freq[i]!=0) {
        			System.out.println(false);
            		return;
        		}
        			
        	}
        	System.out.println(true);       	
        }
        else
        	System.out.println(false);
		
	}

}
