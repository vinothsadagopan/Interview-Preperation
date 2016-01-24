class PrintLeadersInArray {
	public static void printLeaders(int[] input) {
		int i = input.length -1;
		int leader = input[input.length -1];
		i--;
		System.out.print(leader+" ");
		while(i > 0) {
			if(input[i]>leader) {
				System.out.print(input[i]+" ");
				leader = input[i];

			}
			i--;
		}
	}

	public static void main(String[] args) {
		int[] inputArray = {4,12,8,1,3,9};
		printLeaders(inputArray);
	}
}