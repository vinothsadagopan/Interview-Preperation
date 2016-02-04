/*  
Implement a method to perform basic string compression using the counts of replaced repeated characters. For example 
aabcccccaaa would become a2b1c5a3. If hte "compressed " string would not become smaller than the original string, method should return the original string.
You can assume the sstring has only upper and lower casse letters. 

*/
class StringCompress {

	public static void compress(String input) {
		int size = countCompression(input);
		if(size>= input.length()) {
			System.out.println("Could not be compressed");
		}
		else {
			char letter= input.charAt(0);
			int count =1;
			StringBuffer output = new StringBuffer();
		
			for (int i =1;i<input.length();i++ ) {
				if(letter == input.charAt(i)) count++;
				else {

					output.append(letter);
					output.append(count);
					letter = input.charAt(i);
					count =1;
				}
			}
			output.append(letter);
			output.append(count);
			System.out.println(output);
		}
	}
	public static int countCompression(String input) {
		if(input == null || input.isEmpty()){
			return 0;
		}
		int size = 0;
		char letter = input.charAt(0);
		int count =1;
		for (int i =1;i< input.length() ;i++ ) {
			if (letter == input.charAt(i)) {
				count++;
			}
			else {
				letter = input.charAt(i);
				size+=1+String.valueOf(count).length();
				count =1;
			}
		}
		size+=1+String.valueOf(count).length();
		return size;

	}

	public static void main(String[] args) {
		String input ="aabcccccaaa";
		compress(input);
	}
}