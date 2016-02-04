/*	Chapter 11 6th Question (Cracking the coding interview 5th edition)
	Given M * N matrix in which each rows and each column are sorted in ascending order, write a method to 
	find an element
*/

class SortedMatrixSearch {
	/*This algorithm is called as staircase search*/
	public static boolean search(int[][] m, int element) {
		if(element< m[0][0] || element > m[m.length-1][m[0].length-1]) return false;
		int r =0;
		int c = m[0].length -1;
		while(c>=0 && r< m.length) {
			if(m[r][c] == element) return true;
			else if(m[r][c]< element) r++;
			else c--;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] m = {
			{20,35,80,90},
			{30,55,95,105},
			{50,80,100,120}
		};
		System.out.println("Is 60 present in sorted matrix "+search(m,60));
		System.out.println("Is 55 present in sorted matrix "+search(m,55));
	}
}