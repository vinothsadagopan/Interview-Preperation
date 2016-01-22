/*
	Function to return majority element present in the array that is the element that has occured more than helf the length of array.
	For example [1,2,3,2,2] 2 has occured three times in an array of length 5.
	Lets have two variables say candidate and count;
	first candidate =1 make count 1
	if next number! = candidate and their count is 1 replace candidate and count
	if count is more than 1 
	runanother loop and get exact count of the candidate... if the couunt for a  particular candidate is more htna half of the size of array return that number else 0
*/
class MajorityElement {
	public static void majorityElement(int [] input) {
		int i =1;
		int candidate = input[0];
		int count =1;
		while(i< input.length) {
			if(candidate == input[i]) {
				count++;
				i++;
			}
			else {
				if(count ==1) {
					candidate = input[i];
					i++;
					count =1;
				}
			}

		}
		count=0;
		for (int j=0;j<input.length ;j++ ) {
			if(input[j] == candidate) count++;
		}
		System.out.println(count);
		if(count > input.length/2) {
			System.out.println("Majority element is "+candidate);
		}
		else {
			System.out.println("There are no mjor element in the array");
		}

	}
	public static void main(String[] args) {
		int[] input ={1,2,3,2,2,1};
		majorityElement(input);
	}
}