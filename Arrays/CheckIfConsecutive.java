/*
implement a function that checks itf there are consecutive elements present in the array
*/
class CheckIfConsecutive {
	public static boolean isConsecutive(int[] input) {
		int minElement=input[0];
		int maxElement=input[0];
		for(int i=1;i<input.length;i++) {
			if(input[i] <minElement) minElement = input[i];
			else if(input[i]>maxElement) maxElement = input[i];
		}
		if(maxElement -minElement +1 >input.length) return false;
		else {
			for(int i=0;i<input.length;i++) {
				input[i] -=minElement; 
			}
			for(int i=0;i< input.length;i++) {
				int index = Math.abs(input[i]);
				if(input[index]==0) {
					input[index]= -input.length;
				}
				else if(input[index] < 0) {
					return false;
				}
				else {
					input[index]=-input[index];
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] input={1,2,3,5,5};
		System.out.println("Does the given input array is consecutive "+isConsecutive(input));
	}
}