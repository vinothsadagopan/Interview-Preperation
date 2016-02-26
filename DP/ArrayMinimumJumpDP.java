class ArrayMinimumJumpDP {
	public static int minJumps(int arr[])
	{
    	int[] jumps = new int[arr.length];  // jumps[n-1] will hold the result
    	int i, j;
 
    	if (arr.length== 0 || arr[0] == 0)
        	return 0;
 
    	jumps[0] = 0;
 
    // Find the minimum number of jumps to reach arr[i]
    // from arr[0], and assign this value to jumps[i]
    	for (i = 1; i < arr.length; i++)
    	{
        	jumps[i] = 0;
        	for (j = 0; j < i; j++)
        	{
            	if (i <= j + arr[j] && jumps[j] != 0)
            	{
                	 jumps[i] = Math.max(jumps[i], jumps[j] + 1);
                 	break;
            	}
        	}
    	}
    	return jumps[arr.length-1];
}

	public static void main(String[] args) {
		int[] arr ={1,4,3,7,1,2,6,7,6,10};
		System.out.println("minimum jumps are "+minJumps(arr));
	}
}