/*
	To print matrix diagonally.
*/

class printDiagnolMatrix{
	public static void printDiagnol(int[][]m) {
		int rowHeight = m.length;
		int columnHeight =m[0].length;
		System.out.println("row height "+rowHeight);
		System.out.println("column Height "+columnHeight);
		//Step1. Print row count diagonals
		for(int i = rowHeight -1, j =0; i>=0&& j< columnHeight;i--) {
			int x= i;
			int y=j;
			while(x>=0 &&  y< columnHeight) {
				System.out.print(m[x][y] +" ");
				x--;
				y++;
			}
			System.out.println();
		}
		//Step2. Print column count diagonals
		for(int i= rowHeight -1, j=1;i>=0&& j< columnHeight ;j++) {
			int x= i;
			int y=j;
			while(x>=0 &&  y< columnHeight) {
				System.out.print(m[x][y]+" ");
				x--;
				y++;
			}
			System.out.println();
		}
	}
		
	

	public static void main(String[] args) {
		int[][]m = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16},
			{17,18,19,20}
		};
		printDiagnol(m);
	}
}