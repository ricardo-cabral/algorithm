package eu.ricardocabral.algorithm;

/**
 * 
 * Manacher (1975) found a linear time algorithm for listing palindromes that
 * appear at the start of a given string- O(n)
 * 
 * texts to understand:
 * http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
 * http://articles.leetcode.com/longest-palindromic-substring-part-i
 * http://articles.leetcode.com/longest-palindromic-substring-part-ii
 * https://www.youtube.com/watch?v=nbTSfrEfo6M
 * @author Ricardo
 *
 */
public class LongestPalindromic {

	
	public static void main(String[] args) {
		String s = "1aba2";
		String s1 = "HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE";
		String s2 = "abababa";
			
		System.out.println(longestPalindrome(s));
		//System.out.println(longestPalindrome(s1));
		//System.out.println(longestPalindrome(s2));
	}
	
	private static String longestPalindrome(String string) {
	    if(string==null || string.length()<=1)
	        return string;
	 
	    int len = string.length();
	    int maxLen = 1;
	    boolean [][] dp = new boolean[len][len];
	 
	    String longest = null;
	   
	    for(int l=0; l<string.length(); l++){
	        for(int i=0; i<len-l; i++){
	            int j = i+l;
	            if(string.charAt(i)==string.charAt(j) && (j-i<=2||dp[i+1][j-1])){
	                dp[i][j]=true;
	 
	                if(j-i+1>maxLen){
	                   maxLen = j-i+1; 
	                   longest = string.substring(i, j+1);
	                }
	            }
	        }
	    }
	 
	    return longest;
	}
}
