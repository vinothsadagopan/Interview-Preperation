
/*
	Question :To rotate aarray for k times
*/
class RotateArrayForK {
	public static void rotateForK(int[] input, int k) {
		reverse(input, 0,input.length-1);
		reverse(input, 0, k-1);
		reverse(input,k, input.length-1);
		printArray(input);
	}
	public static void reverse(int[] input, int start, int end) {
		while(start<end) {
			int temp = input[start];
			input[start]=input[end];
			input[end] = temp;
			start++;
			end--;
		}
	}
	public static void printArray(int[] input) {
		for(int n: input) {
			System.out.print(n+" ");
		}
	}

	public static void main(String[] args) {
		int[] input ={2,4,1,7,8,9};
		rotateForK(input,3);
	}
}