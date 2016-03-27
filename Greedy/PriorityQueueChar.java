import java.util.*;
class Pair {
	char c;
	int f=0;
	boolean present=false;
	Pair(char c,int f) {
		this.c =c;
		this.f=f;
	}
}
class PriorityQueueChar {
	
	
	public static void buildHeap(char[] input) {
		Map<Character, Integer> chFreq = new HashMap<Character, Integer>();
		for(char c: input) {
			if(chFreq.containsKey(c)) {
				int value = chFreq.get(c);
				chFreq.put(c, ++value);
			}
			else {
				chFreq.put(c,1);
			}
		}
		Pair[] charFreq = new Pair[chFreq.size()];
		//System.out.println(chFreq.size());
		int is=0;
		for(Character c: chFreq.keySet()) {
			//System.out.println(is);
			charFreq[is] = new Pair(c, chFreq.get(c));
			is++;
		}
		for(Pair ch: charFreq) {
			System.out.println(ch.c+" "+ch.f);
		}

		for(int i= (charFreq.length-1)/2;i>-1;i--) {
			buildHeap(charFreq, i, charFreq.length);
		}
		for(Pair ch: charFreq) {
			System.out.println(ch.c+" "+ch.f);
		}
	}
	public static void buildHeap(Pair[] charFreq,int index,int n) {
		System.out.println(index);
		int l = left(index);
		int r =right(index);
		int largest = index;
		if(l<n && charFreq[l].f > charFreq[index].f) {
			largest =l;
		}
		if(r<n && charFreq[r].f> charFreq[largest].f) {
			largest=r;
		}
		if(largest!=index) {
			swap(charFreq,index,largest);
			buildHeap(charFreq,largest,n);
		}
	}
	public static void swap(Pair[] charFreq, int index, int largest) {
		Pair temp = charFreq[index];
		charFreq[index] = charFreq[largest];
		charFreq[largest]= temp;
	}
	public static int left (int index) {
		return (2*index)+1;
	}
	public static int right(int index) {
		return (2*index)+2;
	}	
	public static Pair extractMax(Pair[] charFreq, int n) {
		Pair max = charFreq[0];
		charFreq[0]= charFreq[n-1];
		n=n-1;
		buildHeap(charFreq, 0,n);
		return max;
	}
	public static void main(String[] args) {
		String input ="aacbbcc";
		buildHeap(input.toCharArray());
		
	}
}