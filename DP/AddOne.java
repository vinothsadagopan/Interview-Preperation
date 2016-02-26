public class AddOne {
    public int[] plusOne(int[] digits) {
        int[]output;
        int sum=0,carry=0;
        int countOfNine=0;
        int length = digits.length;
        for(int i=0;i<length;i++) {
            if(digits[i]==9) countOfNine++;
        }
        if(countOfNine==length) {
            output= new int[length+1];
            output[0]=1;
            return output;
        }
        else {
            output= new int[length];
        }
        sum = digits[length-1]+1;
        carry = sum/10;
        output[output.length-1]=sum%10;
        int i = length-2;
        while(i>=0) {
            sum= carry+digits[i];
            carry=sum/10;
            sum=sum%10;
            output[i]=sum;
            i--;
            
        }
        
        return output;
        
    }
    public static void main(String[] args) {
        
    }
}