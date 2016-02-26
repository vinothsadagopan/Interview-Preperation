/*
	Topic: Dynamic Programming 
	Algorithm : Longest Common Subsequence
	Input1: abcdaf
	Input2: acbcf
*/
/*
	To get the longest common subsequence characters
*/
class LongestCommonSubsequence{
	public static String sequenceLength(char[] input1, char[]input2) {
		int[][] seq = new int [input1.length+1][input2.length+1];
		for(int i=0;i<seq.length;i++) {
			seq[i][0]=0;
		}
		for(int i=1;i<seq[0].length;i++) {
			seq[0][i]=0;
		}
		for(int i=1; i<seq.length;i++) {
			for(int j=1;j<seq[0].length;j++) {
				if(input1[i-1]==input2[j-1]) {
					seq[i][j] = seq[i-1][j-1] +1;
				}
				else {
					seq[i][j] = Math.max(seq[i-1][j],seq[i][j-1]);
				}
			}
		}
		//return seq[seq.length-1][seq[0].length-1];
		StringBuilder sb = new StringBuilder();
			int i=seq.length-1;
			int j=seq[0].length-1;
			while(i>0&&j>0) {
				if(seq[i][j]==seq[i-1][j]) {
					i--;
				}
				else if(seq[i][j]==seq[i][j-1]) {
					j--;
				}
				else  {
					sb.insert(0,input1[i-1]);
					i--;
					j--;
				}
			}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		String input1="abcdaf";
		String input2="acbcf";
		System.out.println("Longest Common Subsequence is "+sequenceLength(input1.toCharArray(),input2.toCharArray()));
	}
}