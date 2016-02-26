class Combination {
	public static void printArray(char[] result, int pos) {
		for(int i=0;i< pos;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}
	public static void combine(char[] input,char[]result, int pos, int start) {
		printArray(result, pos);
		for(int i=start; i<input.length;i++) {
			result[pos]= input[i];
			combine(input,result, pos+1,i+1);
		}
	}
	public static void main(String[] args) {
		String input ="ABC";
		char[] result = new char[input.length()];
		combine(input.toCharArray(),result,0,0);
	}
}