/*	Cracking the coding interview (5th edtion)
	Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
*/
class MakeZeroMatrix {
	public static int[][] makeZeros(int[][]m) {
		boolean[] row = new boolean[m.length];
		boolean[] col = new boolean[m[0].length];
		for(int i=0;i<m.length;i++) {
			for (int j=0;j<m[0].length ; j++ ) {
				if(m[i][j]==0) {
					row[i]=true;
					col[j]=true;
				}
			}
		}
		for(int i = 0; i<m.length;i++) {
			if(row[i]) nullifyRow(m, i);
		}
		for(int j=0; j< m[0].length;j++) {
			if(col[j]) nullifyColumn(m,j);
		}
		//print(m);
		return m;
	}
	public static  void nullifyRow(int[][]m,int row) {
		for(int i=0;i<m[0].length;i++) {
			m[row][i] = 0;
		}
	}
	public static void nullifyColumn(int[][]m, int col) {
		for(int i=0;i<m.length;i++) {
			m[i][col] =0;
		}
	}
	public static void print(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0; j<m[0].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][]m = {
			{1,2,3},
			{4,5,0},
			{7,8,9}
		};
		print(m);
		System.out.println("After converting the matrix into zeros ");
		m=makeZeros(m);
		print(m);
	}
}