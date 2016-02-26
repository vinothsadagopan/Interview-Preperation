/*
	Topic: Dynamic Programming
	Question: For a given set of numbers, find whether a subset exists with equivalent to the given sum.
	Algorithm: 
	1. Construct a matrix with 0 to sum as number of rows and 0 to input.length as number of columns.
	2. Fill the table in such a way that each row value is a set and check whether it satisfies the sum value in row.
		2A. if the sum in column is lesser than the set value in row.... we can check if previous value in the set row satisfies the sum(bec if sum is value is lesser than set value, 
		by adding current set value would be obviously greater than sum. Hence take the previous value in the table for the sum.) 
		2B. if the sum in the column value is greater than ore equal to the set value then it subtracts sum value and and the current value in the set and it checks whether the entry 
		for hte reminder value is True or False in the matrix. 
	3. By filling the matrix with this logic, the last entry in the matrix (True or False) would reveal if the given set contains subset equal to the sum.   

*/

class SubSetSum{
	public static boolean isSubset(int[] input, int sum) {
		boolean[][] subset  = new boolean[input.length+1][sum+1];
		for(int i=0;i<=input.length;i++) {
			subset[i][0]=true;
		}
		for(int i=1;i<=sum;i++) {
			subset[0][i] = false;
		}
		for(int i=1;i<=input.length;i++) {
			for(int j=1;j<=sum;j++) {
				subset[i][j]=subset[i-1][j];
				if(subset[i][j]==false && j>=input[i-1]) {
					subset[i][j]= subset[i][j] || subset[i-1][j -input[i-1]];
				}
			}
		}
		return subset[input.length][sum];

	}

	public static void main(String[] args) {
		int[] input = {1,3,9,2};
		if(isSubset(input, 5)) System.out.println("Sub array found");
		else System.out.println("Sub array not found");
		
	}
}