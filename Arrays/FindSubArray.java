/*
	TO find sub array in a given input array for given sum.
*/

class FindSubArray {
	public static int findsubarraysum(int[]input, int sum) {
		int i=0,j=1;
		int cuur_sum = input[0];
		while(i<input.length && j<input.length) {
			if(cuur_sum==sum) {
				System.out.println("Sub array index between "+i+" and "+i);
				return 1;
			}
			if(input[i]+input[j] == sum) {
				System.out.println("Sub array index between "+i+" and "+j);
				return 1;	
			}
			if(j<input.length && input[i] +input[j] <sum ) {
				j++;
			}
			else {
				while(i<j && input[i] +input[j] > sum) {
					i++;
				}
			}
		}
		return 0;
 
	}
	public static void main(String[] args) {
		int[] input ={14, 2, 4, 8, 9, 5, 10, 23};
		if(findsubarraysum(input,15)==1) {
			System.out.println("Sub array found");
		}
		else {
			System.out.println("Sub array not found");
		}
	}
}