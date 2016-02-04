import java.util.*;
class IntersectionSort {
 static int[] sortIntersect(int[] f, int[] m) {
        Integer[]female = new Integer[f.length];
        int k =0;
        Integer[]male = new Integer[m.length];
        for(int i: f) {
            female[k++] = Integer.valueOf(i);
        }
        k=0;
        for(int value:m) {
            male[k++] = Integer.valueOf(value);
        }
        Arrays.sort(female,Collections.reverseOrder());
        Arrays.sort(male,Collections.reverseOrder());
        for(int i : female) {
            System.out.print(i+" ");
           }
           System.out.println();
           for(int i : male) {
            System.out.print(i+" ");
           }
           System.out.println();
        int i =0;
        int j =0;
        int countofSimilarNumbers = 0;
        int[] output = new int[ f.length+ m.length];
        int outputIndex = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        while(i<f.length && j<m.length) {
            System.out.println(female[i]);
            System.out.println(male[j]);
            if(female[i]<male[j]) {
                j++;
            }
           else if(male[j]<female[i]){ 
            System.out.println("hitting that male is lesser");
            i++;
           } 
           else if(female[i]==male[j]) {
                System.out.println(female[i] +" helo");
                countofSimilarNumbers= countofSimilarNumbers+2;
                //map.put(female[i],2);
                int number= female[i];
                int x=i+1;
                int y =j+1;
                while(x<female.length && female[x]==number) {
                    countofSimilarNumbers++;
                    x++;
                }
                 while(y<male.length && male[y]==number) {
                    countofSimilarNumbers++;
                    y++;
                }
                 map.put(female[i],countofSimilarNumbers);
                
                if(x>i+1) {
                    i=x;
                }
                if(y>j+1) {
                    j=y;
                } 
                i++;
                j++;
                countofSimilarNumbers=0;
                
                    
            } 
            i++;
                j++;
                countofSimilarNumbers=0;   
        }
        for(int key: map.keySet()) {
            int value = map.get(key);
            int v =0;
            while(v<value/2) {
                     output[outputIndex++]= key;
                    v++;
                } 
        }
        return output;

    }
    public static void main(String[] args) {
           int[] f = {
            5,
            7000,
            7000,
            12000,
            13000,
            6900,
            7,
            6910,
            7010,
            7000,
            12000,
            18000,
            15000,
            10450,

           };
           int[] m = {
               12000,
                7000
 

           };
           int[] output = sortIntersect(f,m);
           for(int i : output) {
            System.out.print(i+" ");
           }
       }   
}
 