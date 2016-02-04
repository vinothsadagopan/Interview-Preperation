/*

*/
class MatrixRotation {
	public static int[][] rotate(int[][]m) {
		for (int layer = 0;layer<m.length/2 ;++layer ) {
			int first = layer;
			int last = m.length -1-layer;
			for(int i =first; i<last;++i) {
				int offset = i-first;
				int top = m[first][i];
				m[first][i] = m[last-offset][first];
				m[last-offset][first] = m[last][last-offset];
				m[last][last-offset] = m[i][last];
				m[i][last] = top;

			}
		}
		return m;
	}
	public static void print(int[][]m) {
		for(int i=0; i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();

		}
	}
	public static void main(String[] args) {
		int[][]m = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		print(m);
		System.out.println("After rotation");
		m = rotate(m);
		print(m);
	}
}