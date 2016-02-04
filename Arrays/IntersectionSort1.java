import java.util.*;
class IntersectionSort1 {
	
public static int[] sortIntersect(int[]f, int[]m) {
	Arrays.sort(f);
	Arrays.sort(m);
	int[] output = new int[f.length+m.length];
	int i=0,j=0;
	int outputIndex=0;
	while(i<f.length && j<m.length) {
		if(f[i] < m[j]) {
			i++;
		}
		else if(m[j]<f[i]) {
			j++;
		}
		else if(f[i]==m[j]){
			output[outputIndex]=f[i];
			outputIndex++;
			i++;
			j++;
		}
	}
	return output;
}
	public static void main(String[] args) {
		int[] f = {7000,7000,12000,13000,6900,12000,12000};
		int[] m = {18000,15000,18000,15000,10450,7000};
		int [] output = sortIntersect(f,m);
		for(int value: output) {
			System.out.print(value+" ");
		}
	}
}