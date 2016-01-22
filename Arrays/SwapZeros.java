/*
to swap zeros and ones left and right respectiverly in array
[0,1,1,0,0,1,1,0]------> [0,0,0,0,1,1,1,1]

*/
class SwapZeros {

	public static int[] swapZeros(int[] input) {
		int i =0;
		int j = input.length - 1;
		while(i < j) {
			if(input[i]==1 && input[j]==0) {
				int temp = input[i];
				input[i]=input[j];
				input[j]=temp;
				i++;
				j--;
			}
			else if(input[i]==0 && input[j]==0) {
				i++;
				
			}
			else if(input[i]==1 && input[j]==1) {
				j--;
			}
		}
		return input;

	}
	public static void main(String[] args) {
		int[] input = {0,1,1,0,0,1,1,0};
		int[] output = swapZeros(input);
		for(int n:output) {
			System.out.print(n+" ");
		}
	}
}