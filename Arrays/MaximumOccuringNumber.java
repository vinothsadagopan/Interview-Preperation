/*
	TO find maximum occuring number for given k range of number inO(n) time complexity and O(1) space complexity.
*/

class MaximumOccuringNumber {
	public static int maxNumber(int[] input, int k) {
		int i =0;
		while(i<input.length) {
			int index = input[i]%k;
			input[index]+= k;
			i++;
		}
		int maxno = 0;
		int index=0;
		for (int j=0;j<input.length;j++ ) {
			if(input[j]> maxno) {
				maxno = input[j];
				index = j;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		int[] input ={2,3,3,5,3,4,1,7};
		System.out.println("The maximum occuring number is "+maxNumber(input,8));
	}
}