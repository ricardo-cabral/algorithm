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

	}

	/**
	 * isPalindrome has a time complexity of O(n/2) which
	 * is equal to O(n) since Big-O notation ignores constant terms.
	 * isPhrasePalindrome is also O(n) since string transformations are
	 * applied to each of the text’s characters.
	 * 
	 * @param text
	 * @return
	 */
	private static boolean isPalindrome(String text) {
		if (text == null)
			return false;
		char[] textCharArray = text.toLowerCase().toCharArray();
		int left = 0;
		int right = textCharArray.length - 1;
		while (left < right) {
			if (textCharArray[left] == ' ') {
				left++;
				continue;
			}

			if (textCharArray[right] == ' ') {
				right--;
				continue;
			}
			if (textCharArray[left++] != textCharArray[right--])
				return false;
		}

		return true;
	}
}
