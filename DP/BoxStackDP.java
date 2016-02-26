 /*
	This algorithm is to create Maximum height by aranging n number of stack boxes. Given two dimensions of 
 */
 import java.util.Arrays;
 class Dimension implements Comparable<Dimension>{
	int length, width,height;
	Dimension(int length, int width, int height) {
		this.length = length;
		this.width=width;
		this.height=height;
	}
	Dimension() {

	}
	public static Dimension createDimension(int height, int side1, int side2) {
		Dimension d= new Dimension();
		d.height = height;
		if(side1>=side2) {
			d.length=side1;
			d.width= side2;
		}
		else {
			d.length= side2;
			d.width=side1;
		}
		return d;
	}
	public int compareTo(Dimension d1) {
		if(this.length * this.width >=d1.length*d1.width) {
			return -1;
		}
		else {
			return 1;
		}
	}
}
class BoxStackDP {
	public static int createStack(Dimension[] boxes) {
		Dimension[] allRotatedInput = new Dimension[3*boxes.length];
		createAllRotatedInput(boxes, allRotatedInput);
		Arrays.sort(allRotatedInput);
		int[] T = new int[allRotatedInput.length];
		int[] result = new int[allRotatedInput.length];
		for(int i=0;i<T.length;i++) {
			T[i]=allRotatedInput[i].height;
			result[i]=i;
		}
		for(int i=1; i<T.length;i++) {
			for(int j =0;j<i; j++) {
				if(allRotatedInput[i].length<allRotatedInput[j].length && allRotatedInput[i].width<allRotatedInput[j].width) {
					if(T[j]+allRotatedInput[i].height>T[i]) {
						T[i] = T[j]+allRotatedInput[i].height;
						result[i]=j;
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
        for(int i=0; i < T.length; i++){
            if(T[i] > max){
                max = T[i];
            }
        }
        
        return max;
    }
	
	public static void createAllRotatedInput(Dimension[] boxes, Dimension[] allRotatedInput) {
		int index=0;
		for(int i=0; i<boxes.length;i++) {
			allRotatedInput[index++] = boxes[i].createDimension(boxes[i].height,boxes[i].length,boxes[i].width);
			allRotatedInput[index++]= boxes[i].createDimension(boxes[i].length,boxes[i].height,boxes[i].width);
			allRotatedInput[index++]=boxes[i].createDimension(boxes[i].width,boxes[i].length,boxes[i].height);
		}
	}
	public static void main(String[] args) {
		Dimension input[] = { new Dimension(3, 2, 5), new Dimension(1, 2, 4) };
        int maxHeight = createStack(input);
        System.out.println("Max height is " + maxHeight);
	}
}