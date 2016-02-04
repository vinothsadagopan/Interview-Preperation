/*
	
*/
class Ch11Q3 {
	public static int findNum(int[]input, int start, int end, int x) {
		int mid = start+end/2;
		if(input[mid] == x) {
			return mid;
		}
		if(start > end) {
			return -1;
		}
		if(input[mid] < input[end]) { // right part is sorted 
			if(x>=input[mid] && x<=input[end]) {
				return findNum(input, mid+1, end,x);
			}
			else {
				return findNum(input,start, mid-1,x);
			}
		}
		else if(input[start] <input[mid]) { // left part is sorted
			if(x>=input[start] && x<=input[mid]) {
				return findNum(input, start,mid-1,x);
			}
			else {
				return findNum(input, mid+1,end,x);
			}
		}
		else if(input[mid]==input[start]) {// duplicates on left
			if(input[mid]!=input[end]) {/// duplicates on left and no duplicates on right... 
				return findNum(input,mid+1,end,x);
			}
			else {
				int result =findNum(input, start,mid-1,x); // if duplicates are found on both the ends ....full search has to be done ....hence the code below
				if(result ==-1) {
					return findNum(input,mid+1,end,x);
				}
				else {
					return result;
				}
			}

		}
		
		return -1;
	}
	public static void main(String[] args) {
		int[]input = {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println("The index of searching number is "+findNum(input,0,input.length-1,5));
	}
}