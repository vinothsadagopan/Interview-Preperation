class FloodFill {
	public static void fill(int[][]input, int i, int j, int newColor) {
		if(i<0||i>=input.length||j<0||j>=input[0].length) {
			throw new IllegalArgumentException();
		}
		int oldColor = input[i][j];
		fill(input,i,j,newColor,oldColor);
	}
	public static void fill(int[][] input, int i, int j, int newColor,int oldColor) {
		if(i<0||i>=input.length||j<0||j>=input[0].length) {
			return;
		}
		if(input[i][j]==oldColor) {
			input[i][j]=newColor;
			fill(input,i-1,j-1,newColor,oldColor);
			fill(input,i-1,j,newColor,oldColor);
			fill(input,i-1,j+1,newColor,oldColor);
			fill(input,i,j-1,newColor,oldColor);
			fill(input,i,j+1,newColor,oldColor);
			fill(input, i+1,j-1,newColor,oldColor);
			fill(input,i+1,j,newColor,oldColor);
			fill(input,i+1,j,newColor,oldColor);
			fill(input,i+1,j+1,newColor,oldColor);
		}
	}
	private static void printArray(int input[][]) {
        for(int i=0;i<input.length;i++) {
        	for(int j=0;j<input[0].length;j++) {
        		System.out.print(input[i][j]+" ");
        	}
        	System.out.println();
        }
        
    }
	public static void main(String[] args) {
		int[][] input ={{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                      };
        //printArray(input);
        fill(input,4,4,3);
        printArray(input);

	}
}