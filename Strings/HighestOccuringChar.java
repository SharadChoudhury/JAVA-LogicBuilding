package Strings;

public class HighestOccuringChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcdeapapqarr";
		int[] freq=new int[255];
        for(char ch:str.toCharArray()){
            freq[ch]++;
        }
    	
        int max=-1;
        int maxindex=-1;
        for(int i=0;i<255;i++){
            if(freq[i]>max){
                max= freq[i];
                maxindex=i;
            }
        }
        System.out.println((char)maxindex);
	}

}
