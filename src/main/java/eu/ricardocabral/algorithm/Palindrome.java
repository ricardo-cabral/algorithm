package eu.ricardocabral.algorithm;

/**
 * Hello world!
 *
 */
public class Palindrome {
	public static void main(String[] args) {
		
		System.out.println(isPalindrome("Madam"));
		System.out.println(isPalindrome("Motor"));
		System.out.println(isPalindrome("Test"));
		System.out.println(isPalindrome("rotor"));
		System.out.println(isPalindrome("Socorram me subi no onibus em marrocos"));

		System.out.println("Recursive");
		System.out.println(isPalindromeRecursive("Madam"));
		System.out.println(isPalindromeRecursive("Motor"));
		System.out.println(isPalindromeRecursive("Test"));
		System.out.println(isPalindromeRecursive("rotor"));

	}

	/**
	 * isPalindrome has a time complexity of O(n/2) which is equal to O(n) since
	 * Big-O notation ignores constant terms. isPhrasePalindrome is also O(n)
	 * since string transformations are applied to each of the text’s
	 * characters.
	 * 
	 * @param text
	 * @return
	 */
	private static boolean isPalindrome(String text) {
		if (text == null)
			return false;
		//char[] textCharArray = text.toLowerCase().toCharArray();
		int left = 0;
		//int right = textCharArray.length - 1;
		int right = text.length() - 1;
		
		while (left < right) {
			if (Character.isWhitespace(text.charAt(left))) {
				left++;
				continue;
			}

			if (Character.isWhitespace(text.charAt(right))) {
				right--;
				continue;
			}
			if ( Character.toLowerCase(text.charAt(left++)) !=  Character.toLowerCase(text.charAt(right--)))
				return false;
		}

		return true;
	}

	private static boolean isPalindromeRecursive(String text) {
		if (text.length() == 0 || text.length() == 1)
			return true;

		char[] charText = text.toLowerCase().toCharArray();
		int left = 0;
		int right = charText.length - 1;

		return validate(charText, left, right);

	}

	private static boolean validate(char[] text, int left, int right) {
		/*System.out.println("left:" + left + " right:" + right);*/

		if (right < left) {

			return true;
		}

		if (text[left] != text[right]) {

			return false;
		}

		validate(text, ++left, --right);

		return true;
	}
}
