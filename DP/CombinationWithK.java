class CombinationWithK {
	public static void combineK(int[]input, int[] result, int k, int pos, int r) {
		if(pos==input.length) {
			for(int i=0;i<r;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=pos;i<pos+k&&i<input.length;i++) {
			result[r] = formNumber(input,pos,i);
			combineK(input,result, k, i+1,r+1);
		}
	}
	public static int formNumber(int[]input,int start,int end) {
		int num=0;
		for(int i =start;i<=end;i++) {
			num= num*10+input[i];
		}
		return num;
	}
	public static void main(String[] args) {
		int[] input= {1,2,3,4};
		int[] result = new int[input.length];
		combineK(input,result,2,0,0);
	}
}