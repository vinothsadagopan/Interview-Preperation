class UniqueCharacterSubstring {
	public static int subStringLength(String input) {
		if(input==null||input.isEmpty()) {
			return 0;
		}
		if(input.length()<2) {
			return 1;
		}
		int[] charIndex = new int[256];
		int cur_length =1;
		int max_length =1;
		int prev_index;
		charIndex[input.charAt(0)] =0;
		for(int i=0; i<256;i++) {
			charIndex[i]=-1;
		}
		for(int i=1;i<input.length();i++) {
			prev_index= charIndex[input.charAt(i)];
			if(prev_index==-1 || i-cur_length > prev_index)
				cur_length++;
			else {
				if(cur_length >max_length) {
					max_length =cur_length;
					
				}
				cur_length= i- prev_index;
			}
			charIndex[input.charAt(i)]=i;
		}
		if(cur_length >max_length) {
					max_length =cur_length;
					
		}
		return max_length;
	}
	public static void main(String[] args) {
		String input ="ABDEFGABEF";
		System.out.println("Length of the sunstring of unique characters are "+subStringLength(input));
	}
}