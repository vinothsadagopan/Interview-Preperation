/* Chapter 11 Question 1
	You are given two sorted arrays A and B, where A has larger enough buffer that can hold B.
	Write a method to merge B into A in sorted order 
For example A[1,4,7,8,12,15, , , , , , , ] B=[2,3,5,9,10,16,18]

*/

class Ch11Q1{
	
	public static int[] mrege (int[]a, int[]b,int alength, int blength) {
		int indexA = alength-1;
		int indexB=blength -1;
		int indexMerged = alength+blength-1;
		while(indexB>=0) {
			if(a[indexA]> b[indexB]) {
				a[indexMerged]= a[indexA];
				indexA--;
			}
			else {
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
		return a;


	}
	public static void main(String[] args) {
		int[]a= {1,4,7,8,12,15,0 ,0 , 0, 0,0 ,0 ,0 };
		int[]b= {2,3,5,9,10,16,18};
		int[] result = mrege(a,b,6,7);
		for(int n: result) {
			System.out.print(n+" ");
		}
	}
}