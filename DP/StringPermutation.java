public static void permute(char[] input) {
        Map<Character,Integer> map = new TreeMap<Character,Integer>();
        //to count for unique characters in a string, we use Tree Map and it also arranges in sorting order.
        for(char c: input) {
            if(map.containsKey(c)) {
                int value = map.get(c);
                map.put(c,++value);
            }
            else {
                map.put(c,1);
            }
        }
        char[] str = new char[map.size()];
        int[] count = new int[map.size()];
        char[] result = new char[input.length];
        int index=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        permuteUtil(input,str,count,result,0);
    }
    public static void permuteUtil(char[]input,char[]str,int[]count,char[] result, int level) {
        if(level==result.length) {
            printArray(result);
            return;
        }
        for (int i=0;i<str.length;i++) {
            if(count[i]==0) {
                continue;
            }
            result[level]=str[i];
            count[i]--;
            permuteUtil(input,str,count,result,level+1);
            count[i]++;
        }
    }
    public static void printArray(char[] input) {
        for(char c: input) {
            System.out.print(c+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String input = "AABC";
        permute(input.toCharArray());
    }