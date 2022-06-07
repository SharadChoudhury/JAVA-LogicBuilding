package Strings;

public class All_PossibleSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="abcd";
		int n=str.length();
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                System.out.println(str.substring(i,j+1));
            }
        }
	}

}
