package eu.ricardocabral.algorithm;

/**
 * Hello world!
 *
 */
public class Palindrome 
{
    public static void main( String[] args )
    {
        System.out.println(isPalindrome("Madam"));
        System.out.println(isPalindrome("Motor"));
        System.out.println(isPalindrome("Test"));
        System.out.println(isPalindrome("rotor"));
        System.out.println(isPalindrome("Socorram me subi no onibus em marrocos"));
        
    }
    
    
    /**
     * First version using while
     * @param text
     * @return
     */
    private static boolean isPalindrome(String text){
    	if(text == null)
    		return false;
    	char[] textCharArray = text.toLowerCase().toCharArray();
    	int left = 0;
    	int right = textCharArray.length-1;
    	while(left < right){
    		if(textCharArray[left] == ' '){
    			left++;
    			continue;
    		}
    		
    		if(textCharArray[right] == ' '){
    			right--;
    			continue;
    		}
    			if(textCharArray[left++] != textCharArray[right--])
    				return false;
    		}
    	
    	
    	return true;
    }
}
