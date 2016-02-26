/*
	Chapter 8: Question 4 Caracking the Coding Interview 6th Edition
	Algorithm: to Find all subsets for a given set of integers
*/
import java.util.*;
class PowerSetA {
	public static ArrayList<ArrayList<Integer>> allSubSet(int[]list, int index) {
		ArrayList<ArrayList<Integer>> subSets;
		if(index==list.length) {
		    subSets = new ArrayList<ArrayList<Integer>>();
			subSets.add(new ArrayList<Integer>());
		}
		else {
		    subSets = allSubSet(list, index+1);
			int value = list[index];
			ArrayList<ArrayList<Integer>> tempSets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> set:subSets) {
				ArrayList<Integer> midSet = new ArrayList<Integer>();
				midSet.addAll(set);
				midSet.add(value);
				tempSets.add(midSet); 
			}
			subSets.addAll(tempSets);

	
		}
		return subSets;
		
	}

	public static void main(String[] args) {
		int[] input =new int[3];
		input[0] = 0;
		input[1]=1;
		input[2]=2;
		ArrayList<ArrayList<Integer>> subSets = allSubSet(input,0);
		System.out.println(subSets.toString());
	}
}