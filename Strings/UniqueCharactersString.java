/* Chapter 1 Question 1 (Cracking the Coding interview 5th Edition)
To implement an algorithm that determines if a string has all unique characters. What if you cannot use additional data structures?
*/
class UniqueCharactersString {

	public static boolean checkUniqueCharacters(String input) {
		if(input.length() > 128) return false;
		boolean[] char_set = new boolean[128];
		for (int i=0;i< input.length() ;i++ ) {
			int val = input.charAt(i);
			if(char_set[val]) return false;
			else {
				char_set[val] = true;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String input ="Jayalakshmi";
		System.out.println("Does the given string has unique characters "+checkUniqueCharacters(input));
	}
}