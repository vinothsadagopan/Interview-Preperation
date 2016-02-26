
/*
	Question: Longest Common Substring (Dynamic Programming)
	Algorithm:input 1: abcdaf
			  input2: zbcdf
*/
class LongestCommonSubstring {
	public static int subStringLength(char[] input1, char[]input2) {
		int[][] substring = new int[input1.length+1][input2.length+1];
		for(int i=0; i<substring.length;i++) {
			substring[i][0]=0;
		}
		for(int i=1;i<substring[0].length;i++) {
			substring[0][i]=0;
		}
		int maxLength=0;
		for(int i=1;i<substring.length;i++) {
			for(int j=1;j<substring[0].length;j++) {
				if(input1[i-1]==input2[j-1]) {
					substring[i][j]= substring[i-1][j-1] +1;
					if(maxLength<substring[i][j]) {
						maxLength=substring[i][j];
					}
				}
				else {
					substring[i][j]=0;
				}
			}
		}
		return maxLength;
	}
	public static void main(String[] args) {
		String input1= "abcdaf";
		String input2="zbcdf";
		System.out.println("The length of longest common substring are "+subStringLength(input1.toCharArray(),input2.toCharArray()));
	}
}