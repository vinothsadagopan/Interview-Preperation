class MagicIndex {
	public static int getIndex(int[] input, int start,int end) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)/2;
		if(input[mid]==mid) {
			return mid;
		}
		else if(input[mid]>mid) {
			return getIndex(input, start, mid-1);
		}
		else if(input[mid]<mid){
			return getIndex(input,mid+1,end);
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] input = {-40,-20,-1,1,2,3,5,7,9,12,13};
		System.out.println("Magic index for given array is "+getIndex(input,0,input.length-1));
	}
}