package eu.ricardocabral.algorithm;

/**
 * 
 * Manacher (1975) found a linear time algorithm for listing palindromes that
 * appear at the start of a given string- O(n)
 * 
 * texts to understand:
 * https://www.youtube.com/watch?v=obBdxeCx_Qs
 * http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
 * http://articles.leetcode.com/longest-palindromic-substring-part-i
 * http://articles.leetcode.com/longest-palindromic-substring-part-ii
 * https://www.youtube.com/watch?v=nbTSfrEfo6M
 * http://www.ideserve.co.in/
 * @author Ricardo
 *
 */
public class LongestPalindromic {

	
	public static void main(String[] args) {
		String s = "1aba2";
		String s1 = "HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE";
		String s2 = "abababa";
		String s3 = "banana";
			
		System.out.println(longestPalindrome(s3));
		//System.out.println(myLongestPalindrome(s));
		//System.out.println(myLongestPalindrome(s1));
		//System.out.println(longestPalindrome(s2));
	}
	
	
	private static String myLongestPalindrome(String string){
		if(string==null || string.length()<=1)
	        return string;
		
		int stringSize = string.length();
		int maxLenght = 1;
		String longest = null;
		
		for (int i = 0; i < stringSize; i++) {
			for (int j = 0; j < stringSize -1; j++) {
				//int k = i+j;
				
				if(string.charAt(i) == string.charAt(j) && (j-i <= 2)){
					if(j-i+1 > maxLenght){
						maxLenght = j-i+1;
						longest = string.substring(i, j+1);
					}
				}
			}
		}
		
		return longest;
		
		
	}
	
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	private static String longestPalindrome(String string) {
	    if(string==null || string.length()<=1)
	        return string;
	 
	    int n = string.length();
	    int beginsAt = 0; //this is the index where the longes palindrome starts.
	    int maxLength = 1; //the length of the longest palindrome.
	    
	    boolean palindromeMatrix[][] = new boolean[n][n];
	    
	    /*
	     * * B A N A N A
	     * B T F F F F F
	     * A   T F T F T 
	     * N     T F T F
	     * A       T F T
	     * N         T F
	     * A           T
	     * 
	     * longest: anana
	     */
	    
	    //this will update all letters to true
	    for (int i =0; i < n; i++){
	    	palindromeMatrix[i][i] = true;
		    /*
		     * * B A N A N A
		     * B T 
		     * A   T  
		     * N     T 
		     * A       T 
		     * N         T 
		     * A           T
		     *  
		     */
	    }
	    
	    //palindromes of two characters
	    for(int i =0; i < n -1; i++){
	    	if(string.charAt(i) == string.charAt(i+1)){
	    		palindromeMatrix[i][i+1] = true;
	    		beginsAt = i;
	    		maxLength = 2;
	    	}
	    }
	    
	    //palindromes from length 3 to n
	    for(int currentLength = 3; currentLength <=n; currentLength++){
	    	for (int i = 0; i < n-currentLength + 1; i++){
	    		int j = i+currentLength-1;
	    		if(string.charAt(i) == string.charAt(j) //-> first and last character must match
	    			&& palindromeMatrix[i+1][j-1]){ // the rest of the substring must be a palindrome too
	    				palindromeMatrix[i][j] = true;
	    				beginsAt =i;
	    				maxLength = currentLength;
	    			}
	    	}
	    }
	    
	    return string.substring(beginsAt, maxLength+beginsAt);
	}
	
	
}
