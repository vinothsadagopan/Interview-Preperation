class LongestIncreasingSubsequence {
	public static int sequenceLength(int[] input) {
		int[] noOfSeq= new int[input.length];
		for(int i=0;i<noOfSeq.length;i++) {
			noOfSeq[i]=1;
		}
		for(int i=1;i<input.length;i++) {
			for(int j=0;j<i;j++) {
				if(input[j]<input[i]) {
					noOfSeq[i]= Math.max(noOfSeq[i],noOfSeq[j]+1);
				}
			}
		}
		int maxValue = noOfSeq[0];
		for (int i=1;i<noOfSeq.length ;i++ ) {
			if(noOfSeq[i]>maxValue) {
				maxValue=noOfSeq[i];
			}

		}
		return maxValue;
	}
	public static void main(String[] args) {
		int[] input ={3,4,-1,0,6,2,3};
		System.out.println("Longest Increasing Subsequence is "+sequenceLength(input));
	}
}