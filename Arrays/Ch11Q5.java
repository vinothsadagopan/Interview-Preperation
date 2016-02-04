/*
	Chapter 11 Question 5 (Cracking the coding interview 5th edition)
	Given a sorted array of strings which is interpressed with empty strings, write a method to find the location of the string.
*/
/*
1. Apply binary search with slight modification
2. that is if mid value is an empty string find first non empty string on every recursion and set the start and  end point accordingly	
*/
class Ch11Q5 {
	public static int search(String[] strings, String str) {
		if (strings==null||str==null||str=="") {
			return -1;
		}
		return searchR(strings, str, 0,strings.length-1);
	}
	public static int searchR(String[] strings, String str, int first, int last) {
		if(first>last) return -1;
		int mid = first+last/2;
		if(strings[mid].isEmpty()) {
			int left = mid -1;
			int right = mid +1;
			while(true) {
				if(left < first && right > last) {
					return -1;
				}
				else if (right<=last && !strings[right].isEmpty()) {
					mid = right;
					break;
				}
				else if(left>=first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
		if(str.equals(strings[mid])) {
			return mid;
		}
		else if(strings[mid].compareTo(str) < 0) {
			return searchR(strings,str,mid+1,last);
		}
		else {
			return searchR(strings,str,first,mid-1);
		}
	}
	public static void main(String[] args) {
		String[] input = {"at","","","","ball","","","car","","","dad","",""};
		System.out.println("The index for the word ball is "+search(input,"ball"));
	}
}