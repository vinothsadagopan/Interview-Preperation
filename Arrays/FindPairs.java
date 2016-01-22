/*
To find pairs that equal sum in an array in java.\
two possible inputs are there which is 
1. Given sorted array ( in that case we can have two pointers on opposite ends and increment and decrement accordingly ...)
2. If it is unsorted then..??
 for eexample [2,9,5,6,8,1] given sum is 14 then
 icl
*/
import java.util.Set;
import java.util.HashSet;
class FindPairs {
	public static void printPairs(int[]input, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i: input) {
			if(set.contains(sum -i)) {

				System.out.println("Pairs are "+i+" and "+(sum-i));
			}
			else {
				set.add(i);
			}
		}

	}
	public static void main(String[] args) {
		int[] input ={2,9,5,6,8,1};
		printPairs(input,14);
		
	}
}