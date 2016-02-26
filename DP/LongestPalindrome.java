
/*
	Question: To return longest palindrome substring for a given string.
	Algorithm: There are two types of palindrome
	1. Odd Palindrome(MADAM)
	2. Even Palindorme(ECCE)
	So traverse through the string and check for even palindrome and odd palindrome

*/

class LongestPalindrome {
	public static String longestPalindromeSubstring(String input) {
		
		if(input==null) {
			return null;
		}
		if(input.length()<2) {
			return input;
		}
		int low,high,start=0,end=0,maxLength=1;
		for(int i=1;i<input.length();i++) {
			// for even palindrome check
			low = i-1;
			high=i;
			while(low>=0 && high<input.length() && input.charAt(low)==input.charAt(high)) {
				start=low;
				end=high;
				maxLength = high-low+1;
				--low;
				++high;
			}
			//TO check for odd palindrome check
			low= i-1;
			high=i+1;
			while(low>=0 && high<input.length()&& input.charAt(low)==input.charAt(high)) {
				start=low;
				end= high;
				maxLength = high-low+1;
				--low;
				++high;
			}
		}
		return input.substring(start,end+1);
	}


	public static void main(String[] args) {
		String input="AFECCE";
		System.out.println("The length of longest substring is "+longestPalindromeSubstring(input));
	}
}