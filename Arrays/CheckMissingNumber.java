/*
	Implement an algorithm to find missing number in a sorted array and return the missing number.
*/
class CheckMissingNumber {
	public static int returnMissingNumber(int[] input,int start, int end) {
		if(start> end) return -1;
		int mid = start+end/2;
		if(input[mid]>mid) {
			System.out.println("ENtering the missing loop "+mid);
			if(mid==0|| input[mid -1]== mid-1) return mid;
		}
		if(input[mid] == mid) {
			System.out.println("entering the equal loop "+mid);
			return returnMissingNumber(input,mid+1,end);
		}
		else {
			return returnMissingNumber(input,start,mid-1);
		}
	}
	public static void main(String[] args) {
		int[] input ={1,2,3,4,6,6};
		System.out.println("Are there any missing numbers "+ returnMissingNumber(input,0,input.length-1));
	}
}