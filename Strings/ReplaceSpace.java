/*Chapter 1 Question 4 (Cracking the Coding Interview 5th Edition)
Write a method to replace all spaces in a string with'%20'. You may assume that the string has sufficient space at the end of the string to hold the additional characters,
and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
EXAMPLE
Input: "Mr John Smith   ,13
Output: "Mr%20Dohn%20Smith"

*/
class ReplaceSpace {
	public static String replace(String input, int size) {
		char[] output_array = new char[input.length()];
		int i = size -1;
		int j = output_array.length -1;
		while(i>=0  && j>=0) {
			if(input.charAt(i)!=' ') {
				output_array[j] = input.charAt(i);
				j--;
				i--; 
			}
			else if(input.charAt(i)==' ') {
				output_array[j] ='0';
				output_array[j-1]='2';
				output_array[j-2]='%';
				i--;
				j=j-3;
			}
		}
		String output = String.valueOf(output_array);
		return output;
	}

	public static void main(String[] args) {

		String input = "Mr John Smith    ";
		String output = replace(input, 13);
		System.out.println(output);
		
	}
}