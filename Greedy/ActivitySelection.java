/*
	Topic: Greedy Algorithms
	Question:http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/

*/

import java.util.*;
class ActivitySelection {
	public static void noOfActivities(int[] start, int[] end,List<Integer> output ,int index) {
		if(index>=start.length) {
			return;
		}
		if(end[output.get(output.size()-1)] <start[index]) {
			output.add(index);
		}
		noOfActivities(start,end, output, index+1);
	}
	public static void main(String[] args) {
		int[] start ={1,3,0,5,8,5};
		int[] end ={2,4,6,7,9,9};
		List<Integer> output = new ArrayList<Integer>();
		output.add(0);
		noOfActivities(start,end,output,1);
		for(int n:output) {
			System.out.print(n+" ");
		}
	}
}