/* Chapter 1 Question 3 (Cracking the coding interview 5th edition)
Given two strings, write a method to decide if one is a permutation of another.
*/
import java.util.Arrays;
class StringPermutation {
	/*First Solution: To sort the words and check if it is equal Time Complexity:O(nlogn)*/
	public static boolean isPermutation(String input1, String input2) {
		char[] input1Array = input1.toCharArray();
		Arrays.sort(input1Array);
		input1= String.valueOf(input1Array);
		char[]input2Array = input2.toCharArray();
		Arrays.sort(input2Array);
		return input1.equals(String.valueOf(input2Array));

	}
	/*Second Solution: Efficient solution. Get count of characters in ASCII value and  check if same array values are getting filled for second array*/
	public static boolean permutation(String input1, String input2) {
		int[] letters = new int[128];// Assuming ascii values.
		char[] input1_array = input1.toCharArray();
		for(char c:input1_array) {
			letters[c]++;
		}
		for (int i=0;i<input2.length() ; i++) {
			int c = input2.charAt(i);
			if(--letters[c] <0) return false;			
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(permutation("cat","tacs"));
	}
}