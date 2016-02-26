/*
	Topic: Dynamic Programming.
	Question: For a given string, construct a shortest palindrome
	Algorithm: 
	1. Reverse the string and append it at the later part of the string.
	2. Construct KMP table for the particular constructed string.
	3. At the end of the array remove the common suffix of the reversed word at the end and 
	move the rest of the characters to the front to form the shortest palindrome.
	abcxabx
	000012
*/
class ShortestPalindrome {
	public static String constructShortestPalindrome(String input) {
		String reverse_input = new StringBuilder(input).reverse().toString();
		String longInput = input+"#"+reverse_input;
		int[] KMPArray = new int[longInput.length()];
		int index=0;
		for(int i=1;i<longInput.length();) {
			if(longInput.charAt(index)==longInput.charAt(i)) {
				KMPArray[i]= index+1;
				index++;
				i++;
			}
			else {
				if(index!=0) {
					KMPArray[i]=index-1;
					i++;
				} else {
					i++;
				}
			}
		}
		return reverse_input.substring(0,reverse_input.length()-KMPArray[KMPArray.length-1])+input;
	}
	public static void main(String[] args) {
		String input = "abab";
		System.out.println("The shortest palindrome for the given string is "+constructShortestPalindrome(input));
	}
}