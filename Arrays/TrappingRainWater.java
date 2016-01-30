/*
	To implement an algorithm that returns total amount of water collected on top of towers. 
	Algorithm:
	Basic idea is,
	1. for water to be collected on top of a tower, its left handside and right handside  should have towers that are taller. 
	2. The min height between left and right taller buildings  - current height will give the amount of water that can be collected on top od a building
	3. Hence forth the formula would be rainwater on top of one building = Math.min(maxleftheight,maxrightheight) - current tower
	4. If answer is less than 1 then , current towers height is heigher when compared to either left or right hand side tower and water cannot be collected.
	5. So formual wouls be rainWaterAmount +=Math.max( Math.min(maxleftheight,maxrightheight) - current tower,0);
	6. Maintain a seperate array to get to know the maximum hieght from right to left, So that it would be easy for calculation. 


*/
class TrappingRainWater{
	public static int amountWater(int[] input) {
		int[] maxFromRight = new int[input.length];
		int maxFromLeft =0;
		int maxSeenSoFar=0;
		int rainWaterAmount=0;
		for (int i= input.length-1;i>=0 ;i-- ) {
			if(input[i]>maxSeenSoFar) {
				maxFromRight[i] =input[i];
				maxSeenSoFar = input[i];
			}
			else {
				maxFromRight[i]= maxSeenSoFar;
			}
		}
		for(int i=0;i<input.length;i++) {
			
			rainWaterAmount+= Math.max(Math.min(maxFromLeft,maxFromRight[i])-input[i],0);
			if(input[i]> maxFromLeft) {
				maxFromLeft = input[i];
			}
		}
		return rainWaterAmount;
	}
	public static void main(String[] args) {
		int[] input = { 1, 5, 2, 3, 1, 7, 2, 4 };
		System.out.println(amountWater(input));
	}
}