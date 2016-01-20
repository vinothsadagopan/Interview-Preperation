/*
	Program which merges two sorted arrays
*/
class MergeArray {
	public static int[] mergeArrays(int[]input1, int[] input2) {
		int[] output = new int[(input1.length + input2.length)];
		int i = 0,j=0,k=0;
		while(i< input1.length && j<input2.length) {
			if(input1[i]<input2[j]) {
				output[k] = input1[i];
				i++;
				k++;
			}
			else if(input1[i] >input2[j]) {
				output[k] = input2[j];
				j++;
				k++;
			}

		}
		if(i < input1.length) {
			while (i<input1.length) {
				output[k] =input1[i];
				i++;
				k++;
			}
		}
		if(j < input2.length) {
			while (j<input2.length) {
				output[k] =input2[j];
				j++;
				k++;
			}
		}

		return output;

	}

	public static void main(String[] args) {
		int[] input1 = {1,3,5,7,11,14};
		int[] input2 ={2,4,8,19,20,34,78,99};
		int[] output = mergeArrays(input1,input2);
		for (int n :output ) {
			System.out.print(n+" ");
			
		}
	}
}