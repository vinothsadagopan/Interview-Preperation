/*	Chapter 1 Question 8 (Cracking the coding interview 5th edition)
	Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings s1 and s2 write a code to check if s2 
	is a rotation of s1 using only one call to isSubstring function (eg waterbottle is rotation of erbottlewat)
*/
	class StringRotation {
		//This function checks if s2 is a substring of s1
		public static boolean isSubstring(String s1, String s2) {
			return s1.toLowerCase().contains(s2.toLowerCase());
		}
		// Function to check if s2 is rotation of s1
		public static boolean isRotation(String s1, String s2) {
			if(s1.length()==s2.length() && s1.length() > 0) {
				String s1s1 = s1+s1;
				return isSubstring(s1s1,s2);
			}
			return false;

		}

		public static void main(String[] args) {
			String s1 ="erbottlewat";
			String s2 = "waterbottle";
			System.out.println("Is s1 and s2 are results of rotation? "+isRotation(s1,s2));
		}
	}