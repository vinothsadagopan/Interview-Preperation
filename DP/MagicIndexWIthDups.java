class MagicIndexWIthDups {
	public static int getIndex(int[]arr, int start,int end) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)/2;
		if(arr[mid]==mid) {
			return mid;
		}
		/*	Search Left
		*/
		int leftIndex= Math.min(mid-1,arr[mid]);
		int left = getIndex(arr,start,leftIndex);
		if(left>0) {
			return left;
		}
		/* Search right
		*/
		int rightIndex = Math.max(mid+1, arr[mid]);
		int right = getIndex(arr, rightIndex,end);
		
		return right;
		
	}
	public static void main(String[] args) {
		int[]arr = {-10,-5,2,2,2,3,4,5,9,12,13};
		System.out.println("Magic Index is "+getIndex(arr,0,arr.length-1));
	}
}