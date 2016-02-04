/* Chapter 1 Question 2
To implement String Reverse function in Java 
// Substitute for 2nd Question in Cracking the coding interview.
*/
class StringReverse{
	public static String reverseString(String input) {
		char[] stringArray = input.toCharArray();
		int i = 0;
		int j = stringArray.length-1;
		while(i<j) {
			char temp = stringArray[i];
			stringArray[i]= stringArray[j];
			stringArray[j]= temp;
			i++;
			j--;
		}
		input = String.valueOf(stringArray);
		return input;
					 	
		  
	}
	public static void main(String[] args) {
		String input="Vinoth Kumar";
		System.out.println("Reverse value of given string is "+reverseString(input));
	}
}