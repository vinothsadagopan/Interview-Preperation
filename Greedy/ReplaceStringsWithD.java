/*
	Algorithm: Greedy Algorithm, using Binary Heaps.
	Question: Rearrange a string so that all same characters become d distance away
	Url: http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
*/

import java.util.*;
class Pair {
	int number;
	int count;
	Pair(int number, int count) {
		this.number=number;
		this.count = count;
	}
}
class Comparators implements Comparator<Pair> {
	public int compare(Pair o1, Pair o2) {
		if(o1.count<=o2.count) {
			return 1;
		}else {
			return -1;
		}
	}
}
class ReplaceStringsWithD {

	public boolean group(int[] input, int m) {
		
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int number: input) {
			if(map.containsKey(number)) {
				int value= map.get(number);
				map.put(number, ++value);
			}
			else {
				map.put(number,1);
			}
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(map.size(), new Comparators()); 
		for(Integer n: map.keySet()) {
			int value = map.get(n);
			if(value> Math.ceil(input.length *1.0/m)) {
				return false;
			}
			pq.offer(new Pair(n, value));
		}
		int current=0;
		int start=current;
		while(pq.size()>0) {
			Pair p = pq.poll();
			int i=0;
			while(i<p.count) {
				input[start] = p.number;
				start= start+m;
				if(start>=input.length) {
					current++;
					start=current;
				}
				i++;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int input[] = {1,2,3,8,8,8,7,8};
		ReplaceStringsWithD d =new ReplaceStringsWithD();
		boolean r=d.group(input, 3);
		if(r) {
			for(int i=0; i<input.length;i++) {
				System.out.print(input[i]+" ");
			}
		}
		else {
			System.out.println("The formation cannot be formed");
		}

	}
}