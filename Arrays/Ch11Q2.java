/*	Chapter 11 Question 2 (Cracking the coding interview 5th edition)
	Wirte a method to sort array of strings so that all anagrams are next to each other.
*/
	import java.util.Hashtable;
	import java.util.LinkedList;
	import java.util.Arrays;
	class Ch11Q2 {
		public static String[] sort (String[] array) {
			Hashtable<String, LinkedList<String>> table = new Hashtable<String, LinkedList<String>>();
			for(String word:array) {
				String key = sortToChars(word);
				if(!table.containsKey(key)) {
					LinkedList<String> list = new LinkedList<String>();
					System.out.println(key +" "+word);
					list.push(word);
					table.put(key,list);

				}
				else {
					LinkedList<String> list= table.get(key);
					list.push(word);
				}
			}
			int index= 0;
			for(String key: table.keySet()) {
				LinkedList<String> list = table.get(key);
				for (String s :list ) {
					array[index]= s;
					index++;					
				}
			}
			return array;
		}
		public static String sortToChars(String word) {
			char[]wordArray= word.toCharArray();
			Arrays.sort(wordArray);
			return new String(wordArray);
		}
		public static void main(String[] args) {
			String[] words={"cat","man","tac","nam","back"};
			String[] result =sort(words);
			for(String word:result) {
				System.out.print(word+" ");
			}
		}
	}