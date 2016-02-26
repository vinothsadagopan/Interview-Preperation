import java.util.*;
public class MinJumpToReachEnd {

    public int minJump(int arr[],int result[]){
        
        int []jump = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[j] + j >= i){
                    if(jump[i] > jump[j] + 1){
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
        
        return jump[jump.length-1];
    }
    
    public static void main(String args[]){
        Deque<Integer> queue = new LinkedList<Integer>();
        MinJumpToReachEnd mj = new MinJumpToReachEnd();
        //int arr[] = {5,6,0,4,2,4,1,0,0,4};
        //           0,0,0,0,0,0,1,1,5,5
        int arr[] = {2,0};
        int r[] = new int[arr.length];
        int result = mj.minJump(arr,r);
        System.out.println(result);
        System.out.println("---");
        int i = arr.length-1;
        while(i > 0){
            queue.addFirst(r[i]);
            i = r[i];
        }
        int sum=0;
        for(int n: queue) {
            sum+=arr[n];
        }
        System.out.println("Sum :"+sum);
        if(sum==arr.length-1) {
            queue.addLast(arr.length-1);
            for(int n: queue) {
            System.out.print(n+",");
        }
        System.out.print("end");
        }
        else if(sum==0) {
            System.out.println("Failure");
        }
        else {
                for(int n: queue) {
                    System.out.print(n+",");
                }
                System.out.print("end");    
        }
        
        //System.out.print(sum);
    }
}