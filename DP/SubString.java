/*
	Question: To implement an algorithm that checks if a given string is substring of another
	Algorithm: Implemented using KMP algorithm. 
	Time Complexity: O(m+n)
*/

class SubString {
	public static int[] computeKMPArray(char[] pattern) {
		int[] KMPArray = new int[pattern.length];
		int index=0;
		int i=1;
		while(i<pattern.length) {
			if(pattern[index]==pattern[i]) {
				KMPArray[i]=index+1;
				index++;
				i++;
			}
			else {
				if(index!=0) {
					KMPArray[i]= index -1; // KMPArray[i]= index -1; KMPArray[i-1] -1
					i++;
				}
				else {
					i++;
				}
			}
		}
		return KMPArray;
	}
	public static boolean isSubString(char[]input, char[]pattern) {
		int[] KMPValues = computeKMPArray(pattern);
		int i=0,j=0;
		while(i<input.length && j<pattern.length) {
			if(pattern[j]==input[i]) {
				i++;
				j++;
			}
			else {
				if(j!=0) {
					j= KMPValues[j-1];
				}
				else {
					i++;	
				}
				
			}
		}
		if(j==pattern.length) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String input ="abcxabcdabcdabcy";
		String pattern = "abcdabcyxx";
		if(isSubString(input.toCharArray(), pattern.toCharArray())) {
			System.out.println("the given string and pattern are substrings");
		}	
		else {
			System.out.println("The given string and pattern is not a substring");
		}
	}

}